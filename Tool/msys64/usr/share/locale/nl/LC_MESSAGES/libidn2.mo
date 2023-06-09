��    )      d  ;   �      �  �   �  �   u  �   .  c   �     1     J  R  W  N   �  &   �  O         p  #   ~  !   �  *   �  D   �  @   4	  %   u	  &   �	  &   �	  (   �	     
     -
     9
  (   G
  '   p
  4   �
  4   �
  &     /   )  /   Y  7   �  -   �  %   �  %     "   ;     ^  .   t  #   �  '   �     �  �  �  �   �  �   �  �   a  y     %   �     �  q  �  �   -  &   �  L   �     ,  (   ;  *   d  1   �  G   �  B   	  +   L  #   x  #   �  /   �     �  
           1   :  4   l  3   �  3   �  '   	  1   1  1   c  8   �  8   �  ,     -   4  %   b     �  ;   �  (   �  >        K                	   (                                 "          
                                     &                  '                                          #          !          )             %   $          --usestd3asciirules   Enable STD3 ASCII rules
      --no-alabelroundtrip  Disable A-label roundtrip for lookups
      --debug               Print debugging information
      --quiet               Silent operation
   -T, --tr46t               Enable TR46 transitional processing
  -N, --tr46nt              Enable TR46 non-transitional processing
      --no-tr46             Disable TR46 processing
   -d, --decode              Decode (punycode) domain name
  -l, --lookup              Lookup domain name (default)
  -r, --register            Register label
   -h, --help                Print help and exit
  -V, --version             Print version and exit
 A-label roundtrip failed Charset: %s
 Command line interface to the Libidn2 implementation of IDNA2008.

All strings are expected to be encoded in the locale charset.

To process a string that starts with `-', for example `-foo', use `--'
to signal the end of parameters, as in `idn2 --quiet -- -foo'.

Mandatory arguments to long options are mandatory for short options too.
 Internationalized Domain Name (IDNA2008) convert STRINGS, or standard input.

 Try `%s --help' for more information.
 Type each input string on a line by itself, terminated by a newline character.
 Unknown error Usage: %s [OPTION]... [STRINGS]...
 could not convert string to UTF-8 could not determine locale encoding format domain label has character forbidden in non-transitional mode (TR46) domain label has character forbidden in transitional mode (TR46) domain label has forbidden dot (TR46) domain label longer than 63 characters domain name longer than 255 characters input A-label and U-label does not match input A-label is not valid input error out of memory punycode conversion resulted in overflow punycode encoded data will be too large string contains a context-j character with null rule string contains a context-o character with null rule string contains a disallowed character string contains a forbidden context-j character string contains a forbidden context-o character string contains a forbidden leading combining character string contains forbidden two hyphens pattern string contains invalid punycode data string contains unassigned code point string could not be NFC normalized string encoding error string has forbidden bi-directional properties string is not in Unicode NFC format string start/ends with forbidden hyphen success Project-Id-Version: libidn2 2.3.1
Report-Msgid-Bugs-To: bug-libidn2@gnu.org
PO-Revision-Date: 2021-05-16 12:54+0200
Last-Translator: Benno Schulenberg <vertaling@coevern.nl>
Language-Team: Dutch <vertaling@vrijschrift.org>
Language: nl
MIME-Version: 1.0
Content-Type: text/plain; charset=UTF-8
Content-Transfer-Encoding: 8bit
X-Bugs: Report translation errors to the Language-Team address.
Plural-Forms: nplurals=2; plural=(n != 1);
       --usestd3asciirules   de STD3-ASCII-regels inschakelen
      --no-alabelroundtrip  heen-en-terug voor A-labels uitschakelen
      --debug               debug-informatie weergeven
      --quiet               geen meldingen produceren
   -T, --tr46t               transitionele TR46-bewerking inschakelen
  -N, --tr46nt              niet-transitionele TR46-bewerking inschakelen
      --no-tr46             TR46-bewerking uitschakelen
   -d, --decode              domeinnaam decoderen (uit 'punycode')
  -l, --lookup              domeinnaam opzoeken (standaard)
  -r, --register            label registeren
   -h, --help                deze hulptekst tonen en stoppen
  -V, --version             programmaversie tonen en stoppen
 heen-en-terug voor A-label is mislukt Tekenset: %s
 Opdrachtregel-interface voor de Libidn2-implementatie van IDNA2008.

Alle tekenreeksen dienen in de tekenset van uw taalregio gecodeerd te zijn.

Om een tekenreeks die begint met '-' om te zetten, gebruikt u '--' om het
einde van de opties aan te geven.  Bijvoorbeeld: 'idn2 --quiet -- -foo'.

(Een verplicht argument bij een lange optie geldt ook voor de korte vorm.)
   
De gegeven TEKENREEKS (of standaardinvoer) omzetten volgens de regels
die gelden voor geïnternationaliseerde domeinnamen (IDNA2028).

 Typ '%s --help' voor meer informatie.
 Typ elke invoertekenreeks op een afzonderlijke regel, afgesloten met Enter.
 Onbekende fout Gebruik:  %s [OPTIE]... [TEKENREEKS]...
 kan tekenreeks niet naar UTF-8 converteren kan de codering van de taalregio niet achterhalen domeinlabel bevat ongeoorloofd teken in niet-transitionele modus (TR46) domeinlabel bevat ongeoorloofd teken in transitionele modus (TR46) domeinlabel bevat ongeoorloofde punt (TR46) domeinlabel is langer dan 63 tekens domeinnaam is langer dan 255 tekens A-label in invoer en U-label komen niet overeen A-label in invoer is ongeldig invoerfout onvoldoende geheugen beschikbaar de punycode-omzetting resulteerde in een overloop de gecodeerde punycode-gegevens zullen te groot zijn tekenreeks bevat een context-j teken met NULL-regel tekenreeks bevat een context-o teken met NULL-regel tekenreeks bevat een ongeoorloofd teken tekenreeks bevat een ongeoorloofd context-j teken tekenreeks bevat een ongeoorloofd context-o teken tekenreeks begint met een ongeoorloofd combinerend teken tekenreeks bevat ongeoorloofd dubbel verbindingsstreepje tekenreeks bevat ongeldige punycode-gegevens tekenreeks bevat een niet-toegewezen codepunt kan NFKC-normalisering niet uitvoeren tekenreeks bevat coderingsfout tekenreeks heeft ongeoorloofde bidirectionele eigenschappen tekenreeks is niet in Unicode-NFC-opmaak tekenreeks begint/eindigt met ongeoorloofd verbindingsstreepje gelukt 