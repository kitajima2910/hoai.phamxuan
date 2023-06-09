��    )      d  ;   �      �  �   �  �   u  �   .  c   �     1     J  R  W  N   �  &   �  O         p  #   ~  !   �  *   �  D   �  @   4	  %   u	  &   �	  &   �	  (   �	     
     -
     9
  (   G
  '   p
  4   �
  4   �
  &     /   )  /   Y  7   �  -   �  %   �  %     "   ;     ^  .   t  #   �  '   �     �  �  �  �   �  �   �  �   X  w     #   �     �  �  �  }   n  ;   �  R   (     {  )   �  4   �  <   �  H   '  E   p  2   �  '   �  '     2   9  #   l     �     �  4   �  *   �  2     2   A  #   t  +   �  +   �  5   �  9   &  (   `  2   �  .   �     �  9     )   A  ;   k     �                	   (                                 "          
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
PO-Revision-Date: 2021-05-14 17:30+0200
Last-Translator: Jakub Bogusz <qboosh@pld-linux.org>
Language-Team: Polish <translation-team-pl@lists.sourceforge.net>
Language: pl
MIME-Version: 1.0
Content-Type: text/plain; charset=UTF-8
Content-Transfer-Encoding: 8bit
X-Bugs: Report translation errors to the Language-Team address.
       --usestd3asciirules   Włączenie reguł STD3 ASCII
      --no-alabelroundtrip  Wyłączenie przejścia A-U-A przy wyszukiwaniu
      --debug               Wypisywanie informacji diagnostycznych
      --quiet               Działanie po cichu
   -T, --tr46t               Włączenie przetwarzania przejściowego TR46
  -N, --tr46nt              Włączenie przetwarzania nieprzejściowego TR46
      --no-tr46             Wyłączenie przetwarzania TR46
   -d, --decode              Zdekodowanie (z punycode) nazwy domeny
  -l, --lookup              Wyszukanie nazwy domeny (domyślne)
  -r, --register            Zarejestrowanie etykiety
   -h, --help                Wypisanie opisu i zakończenie
  -V, --version             Wypisanie wersji i zakończenie
 przejście A-U-A nie powiodło się Zestaw znaków: %s
 Jest to interfejs linii poleceń do implementacji Libidn2 standardu IDNA2008.

Wszystkie łańcuchy powinny być zakodowane w zestawie znaków właściwym dla
używanej lokalizacji.

Aby przetworzyć łańcuch zaczynający się od `-', np. `-foo', należy użyć
`--', aby zasygnalizować koniec parametrów, np. `idn2 --quiet -- -foo'.

Argumenty obowiązkowe dla długich opcji są również obowiązkowe dla opcji
krótkich.
 Program konwertuje ŁAŃCUCHY lub standardowe wyjście zgodnie ze standardem
IDNA2008 dla umiędzynarodowionych nazw domen.

 Polecenie `%s --help' pozwoli uzyskać więcej informacji.
 Należy podać każdy łańcuch w osobnej linii, zakończony znakiem nowej linii.
 Nieznany błąd Składnia: %s [OPCJA]... [ŁAŃCUCHY]...
 nie udało się przekonwertować łańcucha na UTF-8 nie udało się określić formatu kodowania dla lokalizacji etykieta domeny zawiera znak zabroniony w trybie nieprzejściowym (TR46) etykieta domeny zawiera znak zabroniony w trybie przejściowym (TR46) etykieta domeny zawiera zabronioną kropkę (TR46) etykieta domeny dłuższa niż 63 znaki nazwa domeny dłuższa niż 255 znaków wejściowe etykiety A oraz U nie pasują do siebie wejściowa etykieta A jest błędna błąd wejścia brak pamięci konwersja punycode zakończyła się przepełnieniem dane zakodowane punycode będą zbyt duże łańcuch zawiera znak context-j z pustą regułą łańcuch zawiera znak context-o z pustą regułą łańcuch zawiera niedozwolony znak łańcuch zawiera zabroniony znak context-j łańcuch zawiera zabroniony znak context-o łańcuch zawiera zabroniony wiodący znak łączący łańcuch zawiera zabroniony wzorzec z dwoma łącznikami łańcuch zawiera błędne dane punycode łańcuch zawiera nieprzypisaną wartość kodową normalizacja NFC łańcucha nie powiodła się błąd kodowania łańcucha łańcuch ma zabronione własności dwukierunkowego pisma łańcuch nie jest w formacie Unicode NFC łańcuch zaczyna się lub kończy zabronionym łącznikiem sukces 