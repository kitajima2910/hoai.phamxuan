using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Encodings;
using Org.BouncyCastle.Crypto.Engines;
using Org.BouncyCastle.OpenSsl;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RSA
{
    class RSA2910EncryptAndDecrypt
    {
        public static string RsaEncryptWithPublic(string contentText, string publicKey)
        {
            var publicKeyClone = string.Empty;
            if (!(publicKey.Contains("-----BEGIN PUBLIC KEY-----") && publicKey.Contains("-----END PUBLIC KEY-----")))
            {
                publicKeyClone = "-----BEGIN PUBLIC KEY-----" + publicKey + "-----END PUBLIC KEY-----";
            }
            else
            {
                publicKeyClone = publicKey;
            }

            var bytesToEncrypt = Encoding.UTF8.GetBytes(contentText);

            var encryptEngine = new Pkcs1Encoding(new RsaEngine());

            using (var txtreader = new StringReader(publicKeyClone))
            {
                var keyParameter = (AsymmetricKeyParameter)new PemReader(txtreader).ReadObject();

                encryptEngine.Init(true, keyParameter);
            }

            var encrypted = Convert.ToBase64String(encryptEngine.ProcessBlock(bytesToEncrypt, 0, bytesToEncrypt.Length));
            return encrypted;

        }

        public static string RsaDecryptWithPrivate(string base64Input, string privateKey)
        {
            var privateKeyClone = string.Empty;
            if (!(privateKey.Contains("-----BEGIN PRIVATE KEY-----") && privateKey.Contains("-----END PRIVATE KEY-----")))
            {
                privateKeyClone = "-----BEGIN PRIVATE KEY-----" + privateKey + "-----END PRIVATE KEY-----";
            }
            else
            {
                privateKeyClone = privateKey;
            }

            var bytesToDecrypt = Convert.FromBase64String(base64Input);

            var decryptEngine = new Pkcs1Encoding(new RsaEngine());

            using (var txtreader = new StringReader(privateKeyClone))
            {
                var keyParameter = (AsymmetricKeyParameter)new PemReader(txtreader).ReadObject();

                decryptEngine.Init(false, keyParameter);
            }

            var decrypted = Encoding.UTF8.GetString(decryptEngine.ProcessBlock(bytesToDecrypt, 0, bytesToDecrypt.Length));
            return decrypted;
        }
    }
}
