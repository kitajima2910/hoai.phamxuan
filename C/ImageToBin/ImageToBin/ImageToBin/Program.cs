using System;
using System.Drawing;
using System.IO;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        if (args.Length < 2)
        {
            Console.WriteLine("Usage: ImageToBinary <inputImagePath> <outputTextPath>");
            return;
        }

        string inputImagePath = args[0];
        string outputTextPath = args[1];

        StringBuilder sb = new StringBuilder();

        using (Bitmap bmp = new Bitmap(inputImagePath))
        {
            for (int y = 0; y < bmp.Height; y++)
            {
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color pixelColor = bmp.GetPixel(x, y);

                    // Convert the pixel to grayscale
                    int grayScale = (pixelColor.R + pixelColor.G + pixelColor.B) / 3;

                    // Convert grayscale to binary
                    string binary = grayScale < 128 ? "1" : "0";

                    sb.Append(binary);
                }
                sb.AppendLine();
            }
        }

        File.WriteAllText(outputTextPath, sb.ToString());

        Console.WriteLine("Image converted to binary and saved to " + outputTextPath);
    }
}
