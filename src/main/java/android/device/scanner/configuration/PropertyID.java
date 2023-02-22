package android.device.scanner.configuration;
/**
 * This class contains all supported Scanner sub-system reader properties. Some properties can not supported in different Scanner engine.
 * </br>Zebra Scanner Engine contains SE4710,SE4720, SE4770, SE4750, SE4850
 * </br>Honeywell Scanner Engine contains N6603,N6703, EX30, N4603, HS7(N5703)
 * </br>In this section, * indicates the default option.
 */
//定义取值需确认scanner_default_property.xml是否已经使用.当前可用区间214到250, 120到200
public final class PropertyID {
    /**
     * To set Scanner success beep when SendBroadcast
     * </br>SendBroadcast Values:  {@link #WEDGE_INTENT_ACTION_NAME}
     * {@link #WEDGE_INTENT_DATA_STRING_TAG}
     * </br>Select valid value from the following options：
     * </br>• 0 - None
     * </br>• 1 - Short
     * </br>• *2 - Sharp
     */
    public final static int SEND_GOOD_READ_BEEP_ENABLE = 0x0006;
    /**
     * To set Scanner success vibrate when SendBroadcast
     * </br>SendBroadcast Values:  {@link #WEDGE_INTENT_ACTION_NAME}
     * {@link #WEDGE_INTENT_DATA_STRING_TAG}
     */
    public final static int SEND_GOOD_READ_VIBRATE_ENABLE = 0x0007;
    /**
     * To set Scanner trigger modes
     * </br>Select valid value from the following options：
     * </br>• 2 - PULSE
     * </br>• 4 - Hand-free CONTINUOUS
     * </br>• *8 - HOST
     * </br>See also {@link android.device.scanner.configuration.Triggering}
     *
     */
    public final static int TRIGGERING_MODES = 0x0008;
    /**
     * To set Scanner success beep when keystroke output enable {@link #WEDGE_KEYBOARD_ENABLE}
     * </br>Select valid value from the following options：
     * </br>• 0 - None
     * </br>• 1 - Short
     * </br>• *2 - Sharp
     */
    public final static int GOOD_READ_BEEP_ENABLE = 0x0009;
    /**
     * Reserved.Interface not implemented
     */
    public static final int GOOD_READ_BEEP_AUDIO_FILE = 0x0023;
    /**
     * This property enables & disables vibrate notification after a successful scan,
     * when keystroke output enable {@link #WEDGE_KEYBOARD_ENABLE}
     * </br>Valid Values:
     * </br> *0 Disable
     * </br>  1 Enable
     */
    public final static int GOOD_READ_VIBRATE_ENABLE = 0x000A;
    /**
     * To set Scanner success append the action key character when keystroke output enable {@link #WEDGE_KEYBOARD_ENABLE}
     *
     * </br>Select valid value from the following options：
     * </br>• 0 - None
     * </br>• *1 - Carriage return
     * </br>• 2 - IME action done
     * </br>• 3 - TAB
     */
    public final static int LABEL_APPEND_ENTER = 0x000B;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.</p>
     * To set 2D Scanner Mobile Phone/Display Mode.This mode improves bar code reading performance on mobile phones and electronic displays.
     * </br>Valid Values:
     * </br>VALUE_IMAGE_PICKLIST_MODE_Enable       1
     * </br>VALUE_IMAGE_PICKLIST_MODE_Disable      0
     * </br> VALUE_IMAGE_PICKLIST_MODE_Default     0
     *
     */
    public final static int CELL_DISPLAY_MODE = 0x000C;
    /**
     * @deprecated {@link #CELL_DISPLAY_MODE}
     */
    public final static int IMAGE_PICKLIST_MODE = 0x000C;
    /**
     *This property specifies whether the scan trigger inactive (disable the scan button).
     * {@link android.device.ScanManager#lockTrigger()}
     * </br>Valid Values:
     * </br> *0 Disable
     * </br>  1 Enable
     */
    public final static int TRIGGERING_LOCK = 0x000D;
    /**
     *This property specifies whether the 1D inverse decoder setting:
     * </br>• *0 - Regular Only - the decoder decodes regular 1D bar codes only.
     * </br>• 1 - Inverse Only - the decoder decodes inverse 1D bar codes only.
     * </br>• 2 - Inverse Autodetect - the decoder decodes both regular and inverse 1D bar codes.
     */
    public final static int IMAGE_ONE_D_INVERSE = 0x000E;
    /**
     * When a bar code is scanned, changed the bar code data with this form of regular expression. {@link #SEND_LABEL_PREFIX_SUFFIX}
     * Set the regular expression are data characters.
     * </br>Property is String Data Type.
     * </br>Example:String regular = "[0-9]{5,}";
     * <code>{</code><br>
     *  * <code> &nbsp&nbsp int[] index = new int[]{
     *  PropertyID.LABEL_MATCHER_PATTERN};</code><br>
     *      <code> &nbsp&nbsp String[] value = new String[]{regular};</code><br>
     *      <code> &nbsp&nbsp boolean ret = {@link android.device.ScanManager#setParameterString(index, value)};</code><br>
     *      <code>}</code><br>
     *
     */
    public final static int LABEL_MATCHER_PATTERN     = 0x0024;
    /**
     * This property specifies whether Data format mode.
     * You may use the Data Format mode to change the scan engine’s output. For example, you can use the Data Format mode to
     * insert characters at certain points in bar code data as it is scanned. The selections in the following pages are used only if you
     * wish to alter the output. Default Data Format setting = None.
     * </br>Valid Values:
     * <table border=2>
     *  <tr><td>*0</td><td>None</td></tr>
     *  <tr><td>1</td><td>prefix</td></tr>
     *  <tr><td>2</td><td>suffix</td></tr>
     *  <tr><td>3</td><td>prefix and suffix</td></tr>
     *  <tr><td>4</td><td>regular expression</td></tr>
     *  <tr><td>5</td><td>replace</td></tr>
     *  <tr><td>6</td><td>replace,prefix and suffix</td></tr>
     *  </table>
     */
    public final static int SEND_LABEL_PREFIX_SUFFIX = 0x0025;
    /**
     * This property specifies adds (prepends) the specified characters(s) to the beginning of the acquired data before sending.
     *  First set {@link #SEND_LABEL_PREFIX_SUFFIX} to the Prefix characters.
     * </br>Property is String Data Type.
     */
    public final static int LABEL_PREFIX = 0x0026;
    /**
     * This property specifies adds (appends) the specified characters(s) to the end of the acquired data before sending.
     * First set {@link #SEND_LABEL_PREFIX_SUFFIX} to the Suffix characters.
     */
    public final static int LABEL_SUFFIX = 0x0027;
    /**
     * When a bar code is scanned, the bar code data contains the Hex value characters will hava replace{@link #LABEL_MATCHER_REPLACEMENT}
     * Set the replace source characters are Hex value characters.Property is String Data Type.
     * </br>Example:this “j”  Hex ID is “6A”
     */
    public final static int LABEL_MATCHER_TARGETREGEX = 0x0104;
    /**
     * When a bar code is scanned, with the String value characters to replace the bar code data,
     * if it is contains {@link #LABEL_MATCHER_TARGETREGEX} setting hex characters.
     * Set the replacement characters are Hex value characters.
     * </br>Property is String Data Type.
     * </br>Example barcode data: 017498735071603217160400302000(1D)10140523 the (1D) is HEX GS.
     * </br>when {@link #LABEL_MATCHER_TARGETREGEX} has set value. 1D
     * </br>when {@link #LABEL_MATCHER_REPLACEMENT} has set value. ####
     * </br> output the barcode data: 017498735071603217160400302000####10140523
     */
    public final static int LABEL_MATCHER_REPLACEMENT = 0x0106;
    /**
     *This property specifies whether the bar code data remove the nonprint char.
     *</br>Valid Values:
     * </br> *0 Disable
     * </br>  1 Enable
     *
     */
    public final static int REMOVE_NONPRINT_CHAR = 0x0107;
    /**
     * When a bar code is scanned, ASCII code 1 to 31 in the bar code data is send as key event.
     * </br>Valid Values:
     * </br> *0 Disable
     * </br>  1 Enable
     */
    public final static int SEND_CONTROL_CHAR_AS_EVENTS = 0x0D01;
    /**
     *This property specifies whether the bar code data replace the separator char{@link #LABEL_FORMAT_SEPARATOR_CHAR}.
     * </br>Valid Values:
     * </br> *0 Disable
     * </br>  1 Enable
     */
    public final static int LABEL_SEPARATOR_ENABLE = 0x0109;
    /**
     * When a bar code is scanned, the bar code data contains the Group Seperator char will hava replace{@link #LABEL_SEPARATOR_ENABLE}.
     * Set the replacement characters are 2 characters.
     * </br>Property is String Data Type.Default Value:()
     * </br>Example:{@link #LABEL_MATCHER_TARGETREGEX} is enable and {@link #LABEL_MATCHER_TARGETREGEX} has set value: “#%”
     * </br>Example:GS1-128 code (01)74987350716032(17)160400(30)200(10)14052, out put result：#01%74987350716032#17%160400#30%200#10%14052
     */
    public final static int LABEL_FORMAT_SEPARATOR_CHAR = 0x010A;
    /**
     * This property specifies whether enable Advanced Data Formatting.
     * <p>Advanced Data Formatting permits acquired data to be manipulated
     * based on its contents and/or custom rules configured to trigger (or prevent) actions based on specific criteria.
     * For example, a simple rule can move the cursor ahead four characters or from one text field to another.
     * A complex rule might be created to trigger an action only if the first four digits of an acquired 16-digit number match those of a specific bank.
     * Any number of rules and interdependencies can be created, giving ScanWedge the ability to suit virtually any data processing requirement.</p>
     * </br>Valid Values:
     * </br> *0 Disable
     * </br>  1 Enable
     */
    public final static int ADVANCE_FORMAT_ENABLE = 0x0D02;
    /**
     * @deprecated
     *Reserved.Interface not implemented.On the screen off，This property specifies whether scanner working.
     */
    public final static int TRIGGERING_SLEEP_WORK = 0x010B;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Honeywell scanner.
     * This property specifies whether DPM decoding is enabled during the execution of Decode.
     * </br>The property value should be set as follows:
     * </br>0: Disable DPM decoding
     * </br>1: Dotpeen DPM decoding
     * </br>2: Reflective DPM decoding
     */
    public final static int DPM_DECODE_MODE = 0x010F;
    /**
     * Set the maximum time decode processing continues during a scan attempt.
     * </br>Parameters Values:  value * 100 ms
     * </br>VALUE_LASER_ON_TIME_min       5
     * </br>VALUE_LASER_ON_TIME_max       99
     * </br>VALUE_LASER_ON_TIME_Default      50
     */
    public final static int LASER_ON_TIME = 0x0028;//0x01-0x63 df 0x1e * 100 ms
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * To set  Scanner decoding timeout between same symbol
     * </br>Parameters Values:  value * 100 ms
     * </br>min       1
     * </br>max       99
     * </br>Default   *10
     */
    public final static int TIMEOUT_BETWEEN_SAME_SYMBOL = 0x0029;//0x01-0x63 df 0x30
    /**
     * To set  Scanner linear code type security level
     * </br>Parameters Values:
     * </br>min       0
     * </br>max       3
     * </br>Default   *1
     */
    public final static int LINEAR_CODE_TYPE_SECURITY_LEVEL = 0x002a;//1 2 3 4
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * This feature sets the level of aggressiveness in decoding bar codes with a reduced quiet zone (the area in front
     * of and at the end of a bar code), and applies to symbologies enabled by a Reduced Quiet Zone parameter.
     * Because higher levels increase the decoding time and risk of misdecodes, we strongly recommends enabling
     * only the symbologies which require higher quiet zone levels, and leaving Reduced Quiet Zone disabled for all
     * other symbologies.
     * </br>Parameters Values:
     * </br>• 0 - 1D Quiet Zone Level 0: The decoder performs normally in terms of quiet zone.
     * </br>• *1 - 1D Quiet Zone Level 1: The decoder performs more aggressively in terms of quiet zone.
     * </br>• 2 - 1D Quiet Zone Level 2: The decoder only requires one side EB (end of bar code) for decoding.
     * </br>• 3 - 1D Quiet Zone Level 3: The decoder decodes anything in terms of quiet zone or end of bar code.
     */
    public final static int LINEAR_1D_QUIET_ZONE_LEVEL = 0x0003;
    /**
     * This option is enabled by default to optimize decode performance on 1D bar codes, including damaged and
     * poor quality symbols. Disable this only if you experience time delays when decoding 2D bar codes, or in
     * detecting a no decode.
     * </br>Valid Values:
     * </br> 0 Disable
     * </br> *1 Enable
     */
    public static final int FUZZY_1D_PROCESSING = 0x002b;
    /**
     * This mode enables decoding multiple bar codes within the scanner's field of view.
     * </br>Select one of the following options:
     * </br>• *0 - Disable Multi Decode Mode
     * </br>• 1 - Enable Multi Decode Mode
     */
    public static final int MULTI_DECODE_MODE = 0x002c;
    /**
     * This parameter sets the number of bar codes to read when Multi Decode Mode is enabled. The range is 1 to
     * 10 bar codes. The default is 1.
     */
    public static final int BAR_CODES_TO_READ = 0x002d;
    /**
     *
     * </br>Select when to generate a decode event to the calling application when Multi Decode Mode is enabled.
     * • 0 - Generate a decode event after one or more bar codes are decoded.
     * • *1 - Only generate the callback to app when at least the number of bar codes set in
     * Bar Codes to Read are decoded.
     */
    public static final int FULL_READ_MODE = 0x002e;
    /**
     * This property specifies the character encoding to use for the bar code data.
     * The property is ignored when {@link #CODING_FORMAT_NAME} is set to valid character encoding.
     * </br>Valid Values:
     * <table border=2>
     *  <tr><td>0*</td><td>UTF-8</td></tr>
     *  <tr><td>1</td><td>GBK(GB2312) </td></tr>
     *  <tr><td>2</td><td>BIG5</td></tr>
     *  <tr><td>3</td><td>SHIFT-JIS</td></tr>
     *  <tr><td>4</td><td>ISO-8859-15</td></tr>
     *  <tr><td>5</td><td>US-ASCII</td></tr>
     *  <tr><td>6</td><td>UTF-16</td></tr>
     *  <tr><td>7</td><td>UTF-16BE</td></tr>
     *  <tr><td>8</td><td>UTF-16LE</td></tr>
     *  <tr><td>9</td><td>Auto(UTF-8|GBK)</td></tr>
     *  <tr><td>10</td><td>ISO-8859-15</td></tr>
     *  </table>
     */
    public static final int CODING_FORMAT = 0x002f;

    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Honeywell scanner.
     * This property specifies the exposure mode that will be used during image capture.
     * </br>Valid Values:
     * </br> 0 Fixed exposure
     * </br> 2* Auto-exposure will be used
     *
     */
    public final static int IMAGE_EXPOSURE_MODE = 0x0004;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Honeywell scanner.
     * If exposure mode is FIXED, what is the exposure{@link #IMAGE_EXPOSURE_MODE}.
     * Valid Values Range: 1..600
     */
    public final static int IMAGE_FIXED_EXPOSURE = 0x0005;
    /**
     * A Code ID character identifies the code type of a scanned bar code. This is useful when decoding more than
     * one code type. In addition to any single character prefix already selected, the Code ID character is inserted
     * between the prefix and the decoded symbol.
     * </br>Select valid value from the following options：
     * </br>• *0 - None
     * </br>• 1 - AIM Code ID Character
     * </br>• 2 - Symbol Code ID Character
     */
    public final static int TRANSMIT_CODE_ID = 0x010C;
    /**
     * allows a delay time for keystroke output inter character.
     * </br>Valid Values:
     * </br> 0 ms Minimun
     * </br> 1000 ms Maximun
     */
    public final static int CHARACTER_DATA_DELAY = 0x010D;
    /**
     * allows a delay time for keystroke output key event.
     * </br>Valid Values:
     * </br> 0 ms Minimun
     * </br> 1000 ms Maximun
     */
    public final static int APPEND_ENTER_DELAY = 0x010E;
    /**
     * This property specifies whether Code39 decoding is enabled.
     * </br>Valid Values:
     * </br> 0 Disable
     * </br> *1 Enable
     */
    public final static int CODE39_ENABLE = 0x0100;
    /**
     * Enable this to check the integrity of all Code 39 symbols to verify that the data complies with specified check
     * digit algorithm.
     * </br>Valid Values:
     * </br> *0 - Disable Code 39 Check Digit Verification
     * </br> 1 - Enable Code 39 Check Digit Verification
     */
    public final static int CODE39_ENABLE_CHECK = 0x0102;
    /**
     * This property specifies whether to transmit Code 39 data with or without the check digit.
     * </br>Valid Values:
     * </br> *0 - Do Not Transmit Code 39 Check Digit (Disable)
     * </br> 1 - Transmit Code 39 Check Digit (Enable)
     */
    public final static int CODE39_SEND_CHECK = 0x0103;
    /**
     * Code 39 Full ASCII is a variant of Code 39 which pairs characters to encode the full ASCII character set.
     * This property specifies whether Code 39 Full ASCII is Enable or disable .
     * </br>Valid Values:
     * </br>*0 - Disable Code 39 Full ASCII
     * </br> 1 - Enable Code 39 Full ASCII
     */
    public final static int CODE39_FULL_ASCII = 0x0105;
    /**
     * Enable or disable decoding Code 39 bar codes with reduced quiet zones.
     * </br>Valid Values:
     * </br>*0 - Disable Code 39 Reduced Quiet Zone
     * </br> 1 - Enable Code 39 Reduced Quiet Zone
     */
    public static final int CODE39_Quiet_Zone = 0x0122;
    /**
     * Start/Stop characters identify the leading and trailing ends of the bar code. You may either transmit, or not transmit Start/
     * Stop characters. Default = Don’t Transmit.
     * </br>Valid Values:
     * </br>*0 - Disable Transmit
     * </br> 1 - Enable Transmit
     */
    public static final int CODE39_START_STOP = 0x0123;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * The scanner offers four levels of decode security for Code 39 barcodes. There is an inverse relationship
     * between security and scanner aggressiveness. Increasing the level of security can reduce scanning
     * aggressiveness, so select only the level of security necessary.
     * </br>• Code 39 Security Level 0: The scanner operates in its most aggressive state, while providing sufficient
     * security in decoding most in-spec barcodes.
     * </br>• Code 39 Security Level *1: This default setting eliminates most misdecodes.
     * </br>• Code 39 Security Level 2: This option applies greater barcode security requirements if Security Level
     * 1 fails to eliminate misdecodes.
     * </br>• Code 39 Level 3: If you selected Security Level 2, and misdecodes still occur, select this security level
     * to apply the highest safety requirements.
     */
    public final static int CODE39_SECURITY_LEVEL = 0x0124;
    /**
     * Set minimun length for Code39.Range: 0..55.Default = 1
     * </br>The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODE39_LENGTH1 = 0x0120;
    /**
     * Set maximun length for Code39.Range: 0..55.Default = 55
     * </br>The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODE39_LENGTH2 = 0x0121;
    /**
     * This property specifies whether Trioptic decoding is enabled.
     * </br>Trioptic Code 39 is a variant of Code 39 used in the marking of computer tape cartridges. Trioptic Code 39
     * symbols always contain six characters.
     * </br>Valid Values:
     * </br>*0 - Disable
     * </br> 1 - Enable
     */
    public final static int TRIOPTIC_ENABLE = 0x0108;
    /**
     * This property specifies whether Code32 decoding is enabled.
     * Code 32 is a variant of Code 39 used by the Italian pharmaceutical industry.
     * </br>Valid Values:
     * </br>*0 - Disable
     * </br> 1 - Enable
     */
    public final static int CODE32_ENABLE = 0x0110;
    /**
     * Enable or disable adding the prefix character “A” to all Code 32 bar codes.
     * </br>Valid Values:
     * </br>*0 - Disable
     * </br> 1 - Enable
     */
    public final static int CODE32_SEND_START = 0x0113;
    /**
     * This property specifies whether chinese post decoding is enabled.
     * </br>Valid Values:
     * </br>*0 - Disable
     * </br> 1 - Enable
     */
    public final static int C25_ENABLE = 0x0114;//chinese 25

    /**
     * This property specifies whether Discrete 2 of 5 decoding is enabled.
     * </br>Valid Values:
     * </br>*0 - Disable
     * </br> 1 - Enable
     */
    public final static int D25_ENABLE = 0x0200;
    /**
     * Set minimun length for Discrete 2 of 5.Range: 0..55
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int D25_LENGTH1 = 0x0220;
    /**
     * Set maximun length for Discrete 2 of 5.Range: 0..55
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int D25_LENGTH2 = 0x0221;

    //
    // Matrix 2/5 definitions
    //
    /**
     * This property specifies whether Matrix 2 of 5 decoding is enabled.
     * </br>Valid Values:
     * </br>*0 - Disable
     * </br> 1 - Enable
     */
    public final static int M25_ENABLE = 0x0208;
    /**
     * The check digit is the last character of the symbol used to verify the integrity of the data. Select whether to
     * transmit the bar code data with or without the Matrix 2 of 5 check digit:
     * </br>Valid Values:
     * </br> *0 - Disable Matrix 2 of 5 Check Digit
     * </br> 1 - Enable Matrix 2 of 5 Check Digit
     */
    public static final int M25_ENABLE_CHECK = 0x0209;
    /**
     * This property specifies whether to transmit Matrix 2 of 5 data with or without the check digit.
     * </br>Valid Values:
     * </br> *0 - Do Not Transmit Matrix 2 of 5 Check Digit
     * </br> 1 - Transmit Matrix 2 of 5 Check Digit
     */
    public static final int M25_SEND_CHECK = 0x020D;
    /**
     * Set minimun length for Matrix 2 of 5.Range: 0..55
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public static final int M25_LENGTH1 = 0x020E;
    /**
     * Set maximun length for Matrix 2 of 5.Range: 0..55
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public static final int M25_LENGTH2 = 0x020F;
    /**
     * This property specifies whether Code11 decoding is enabled.
     * </br>Valid Values:
     * </br>*0 - Disable
     * </br> 1 - Enable
     */
    public final static int CODE11_ENABLE = 0x020A;
    /**
     * This feature allows the decoder to check the integrity of all Code 11 symbols to verify that the data complies
     * with the specified check digit algorithm. This selects the check digit mechanism for the decoded Code 11 bar
     * code. To enable this feature, set the number of check digits encoded in the Code 11 symbols:
     * </br>Valid Values:
     * </br>• *0 - Disable Code 11 Check Digit Verification
     * </br>• 1 - 1 Check Digit
     * </br>• 2 - 2 Check Digits
     */
    public final static int CODE11_ENABLE_CHECK = 0x020B;
    /**
     * This property specifies whether or not to transmit the Code 11 check digit(s).
     * </br>Valid Values:
     * </br>*0 - Do Not Transmit Code 11 Check Digit(s) (Disable)
     * </br> 1 - Transmit Code 11 Check Digit(s) (Enable)
     */
    public final static int CODE11_SEND_CHECK = 0x020C;
    /**
     * Set minimun length for Code11.Range: 0..55.Default = 4.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODE11_LENGTH1 = 0x0224;//min 4
    /**
     * Set maximun length for Code11.Range: 0..55.Default = 55.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODE11_LENGTH2 = 0x0225;//

    //
    // Interleaved 2/5 definitions
    //
    /**
     * This property specifies whether Interleaved 2 of 5 decoding is enabled.
     * </br>Valid Values:
     * </br>  0 - Disable
     * </br> *1 - Enable
     */
    public final static int I25_ENABLE = 0x0210;
    /**
     * Enable this feature to check the integrity of all I 2 of 5 symbols to verify the data complies with either the
     * specified Uniform Symbology Specification (USS), or the Optical Product Code Council (OPCC) check digit algorithm.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - USS Check Digit OPCC Check Digits
     */
    public final static int I25_ENABLE_CHECK = 0x0212;
    /**
     * This property specifies whetherto transmit I 2 of 5 data with or without the check digit.
     * </br>Valid Values:
     * </br>*0 - Do Not Transmit I 2 of 5 Check Digit (Disable)
     * </br>• 1 - Transmit I 2 of 5 Check Digit (Enable)
     */
    public final static int I25_SEND_CHECK = 0x0213;
    /**
     * Set minimun length for Interleaved 2 of 5.Range: 0..55.Default = 6.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int I25_LENGTH1 = 0x0228;
    /**
     * Set maximun length for Interleaved 2 of 5.Range: 0..55.Default = 55.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int I25_LENGTH2 = 0x0229;
    /**
     * Enable this parameter to convert 14-character I 2 of 5 codes to EAN-13, and transmit to the host as EAN-13.
     * To accomplish this, the I 2 of 5 code must be enabled, and the code must have a leading zero and a valid
     * EAN-13 check digit.
     * </br>Valid Values:
     * </br>*0 - Do Not Convert I 2 of 5 to EAN-13 (Disable)
     * </br> 1 - Convert I 2 of 5 to EAN-13 (Enable)
     */
    public final static int I25_TO_EAN13 = 0x022A;
    /**
     * Enable or disable decoding I 2 of 5 bar codes with reduced quiet zones
     * </br>The property value should be set as follows:
     * </br>0*: Disallow short quiet zone symbols.
     * </br>1: Allow short quiet zone symbols (on one end only).
     * </br>2: Allow short quiet zone symbols (on both ends).
     */
    public static final int I25_QUIET_ZONE = 0x022B;
    /**
     *<p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.</p>
     * </br>
     * Interleaved 2 of 5 bar codes are vulnerable to misdecodes, particularly when I 2 of 5 Lengths is set to Any
     * Length. The scanner offers four levels of decode security for Interleaved 2 of 5 bar codes. There is an inverse
     * relationship between security and scanner aggressiveness. Increasing the level of security can reduce
     * scanning aggressiveness, so select only the level of security necessary.
     * </br>• 0 - I 2 of 5 Security Level 0: This setting allows the scanner to operate in its most aggressive state,
     * while providing sufficient security in decoding most in-spec bar codes.
     * </br>• *1 - I 2 of 5 Security Level 1: A bar code must be successfully read twice, and satisfy certain safety
     * requirements before being decoded. This default setting eliminates most misdecodes.
     * </br>• 2 - I 2 of 5 Security Level 2: Select this option with greater bar code security requirements if Security
     * Level 1 fails to eliminate misdecodes.
     * </br>• 3 - I 2 of 5 Security Level 3: If you selected Security Level 2, and misdecodes still occur, select this
     * security level. The highest safety requirements are applied. A bar code must be successfully read three
     * times before being decoded.
     */
    public static final int I25_SECURITY_LEVEL = 0x022C;

    //
    // Codabar definitions
    //
    /**
     * This property specifies whether Codabar decoding is enabled.
     * </br>Valid Values:
     * </br>  0 - Disable
     * </br> *1 - Enable
     */
    public final static int CODABAR_ENABLE = 0x0300;
    /**
     * Enable this parameter to strip the start and stop characters from a decoded Codabar symbol. Enable this if the
     * host system requires this data format.
     * </br>Valid Values:
     * </br>*0 - Disable NOTIS Editing
     * </br> 1 - Enable NOTIS Editing
     */
    public final static int CODABAR_NOTIS = 0x0305;
    /**
     * Enable this parameter to strip the start and stop characters and insert a space after the first, fifth, and tenth
     * characters of a 14-character Codabar symbol. Enable this if the host system requires this data format.
     * </br>Valid Values:
     * </br>*0 - Disable CLSI Editing
     * </br> 1 - Enable CLSI Editing
     */
    public final static int CODABAR_CLSI = 0x0306;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * </br>The scanner offers four levels of decode security for Codabar barcodes. There is an inverse relationship
     * between security and scanner aggressiveness. Increasing the level of security can reduce scanning
     * aggressiveness, so select only the level of security necessary.
     * </br>0: This setting allows the scanner to operate in its most aggressive state, while
     * providing sufficient security in decoding most in-spec barcodes.
     * </br>*1: This default setting eliminates most misdecodes.
     * </br>2: Select this option with greater barcode security requirements if Security
     * Level 1 fails to eliminate misdecodes.
     * </br>3: If you selected Security Level 2, and misdecodes still occur, select this
     * security level to apply the highest safety requirements.
     */
    public final static int CB_SECURITY_LEVEL = 0x0307;
    /**
     * Set minimun length for Codabar.Range: 0..55.Default = 4.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODABAR_LENGTH1 = 0x0320;
    /**
     * Set maximun length for Codabar.Range: 0..55.Default = 55.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODABAR_LENGTH2 = 0x0321;
    /**
     * @deprecated This property specifies whether Codabar check digit verification is enable .
     */
    public static final int CODABAR_ENABLE_CHECK = 0x0322;
    /**
     * This property specifies whetherto transmit Codabar data with or without the check digit.
     * <p>Note: The property value below is only supported on platforms interfacing to the Honeywell scanner.
     *
     */
    public static final int CODABAR_SEND_CHECK = 0x0323;
    /**
     * @deprecated
     * Start/Stop characters identify the leading and trailing ends of the bar code. You may either transmit, or not transmit Start/
     * Stop characters. Default = Don’t Transmit.
     * <p>Note: The property value below is only supported on platforms interfacing to the Honeywell scanner.
     *
     */
    public static final int CODABAR_SEND_START = 0x0324;
    /**
     * @deprecated
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * </br>Codabar supports symbol concatenation. When you enable concatenation, the scanner looks for a Codabar symbol having
     * a “D” start character, adjacent to a symbol having a “D” stop character. In this case the two messages are concatenated
     * into one with the “D” characters omitted.
     */
    public static final int CODABAR_CONCATENATE = 0x0325;

    //
    // Code 93 definitions
    //
    /**
     * This property specifies whether Code93 decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int CODE93_ENABLE = 0x0400;
    /**
     * Set maximun length for Code93.Range: 0..55.Default = 4.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODE93_LENGTH1 = 0x0420;
    /**
     * Set maximun length for Code93.Range: 0..55.Default = 55.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODE93_LENGTH2 = 0x0421;

    //
    // Code 128 definitions
    //
    /**
     * This property specifies whether Code 128 decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int CODE128_ENABLE = 0x0408;

    /**
     * Set minimun length for Code 128.Range: 0..55.Default = 1.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODE128_LENGTH1 = 0x0424;
    /**
     * Set maximun length for Code 128.Range: 0..80.Default = 55.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int CODE128_LENGTH2 = 0x0425;
    /**
     * ISBT 128 is a variant of Code 128 used in the blood bank industry. Enable or disable ISBT 128. If necessary,
     * the host must perform concatenation of the ISBT data.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int CODE_ISBT_128 = 0x0426;
    /**
     * Enable or disable decoding Code 128 bar codes with reduced quiet zones
     * </br>The property value should be set as follows:
     * </br>*0: Disallow short quiet zone symbols.
     * </br>1: Allow short quiet zone symbols (on one end only).
     * </br>2: Allow short quiet zone symbols (on both ends).
     */
    public final static int CODE128_REDUCED_QUIET_ZONE = 0x0427;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * The ISBT specification includes a table that lists several types of ISBT bar codes that are commonly used in
     * pairs. If you enable ISBT Concatenation, enable Check ISBT Table to concatenate only those pairs found in
     * this table. Other types of ISBT codes are not concatenated.
     */
    public final static int CODE128_CHECK_ISBT_TABLE = 0x0428;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * Select an option for concatenating pairs of ISBT code types:
     * </br>• *0 - Disable ISBT Concatenation - The device does not concatenate pairs of ISBT codes it encounters.
     * </br>• 1 - Enable ISBT Concatenation - There must be two ISBT codes in order for the device to decode and
     * perform concatenation. The device does not decode single ISBT symbols.
     * </br>• 2 - Autodiscriminate ISBT Concatenation - The device decodes and concatenates pairs of ISBT codes
     * immediately. If only a single ISBT symbol is present, the device must decode the symbol the number of
     * times set via ISBT Concatenation Redundancy before transmitting its data to confirm that there is no
     * additional ISBT symbol.
     */
    public final static int CODE_ISBT_Concatenation_MODE = 0x0429;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * Code 128 bar codes are vulnerable to misdecodes, particularly when Code 128 Lengths is set to Any Length.
     * The decoder offers four levels of decode security for Code 128 bar codes. There is an inverse relationship
     * between security and decoder aggressiveness. Increasing the level of security can reduce scanning
     * aggressiveness, so select only the level of security necessary.
     * </br>• 0 - Security Level 0 - The decoder operates in its most aggressive state, while providing sufficient
     * security in decoding most in-spec bar codes.
     * </br>• *1 - Security Level 1 - This option eliminates most misdecodes while maintaining reasonable
     * aggressiveness.
     * </br>• 2 - Security Level 2 - This option applies greater bar code security requirements if Security Level 1 fails
     * to eliminate misdecodes.
     * </br>• 3 - Security Level 3 - If you selected Security Level 2, and misdecodes still occur, select this security
     * level to apply the highest safety requirements.
     */
    public final static int CODE128_SECURITY_LEVEL = 0x040A;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * @deprecated This feature applies to Code 128 bar codes with an embedded <FNC4> character.
     * • *0 - Disable Ignore Code 128 <FNC4> - The <FNC4> character is not transmitted but the following
     * character has 128 added to it.
     * • 1 - Enable Ignore Code 128 <FNC4> - This strips the <FNC4> character from the decode data. The
     * remaining characters do not change.
     */
    public final static int CODE128_IGNORE_FNC4 = 0x040B;
    //
    //GS1-128
    //
    /**
     * This property specifies whether GS1-128 decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int CODE128_GS1_ENABLE = 0x040C;
    /**
     * @deprecated
     * GS1-128 Emulation Mode for UCC/EAN Composite Codes.
     * This property specifies Enable or disable this mode.
     */
    public final static int GS1128__UCCEAN_Composite = 0x040D;
    //
    // UPC-A definitions
    //
    /**
     * This property specifies whether UPC-A decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int UPCA_ENABLE = 0x0500;
    /**
     * The check digit is the last character of the symbol used to verify the integrity of the data. Select whether to
     * transmit the bar code data with or without the UPC-A check digit. It is always verified to guarantee the integrity
     * of the data.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int UPCA_SEND_CHECK = 0x0502;
    /**
     * Preamble characters are part of the UPC symbol, and include Country Code and System Character. There are
     * three options for transmitting a UPC-A preamble to the host device. Select the appropriate option to match the
     * host system:
     * </br>• *1 - Transmit System Character Only (<SYSTEM CHARACTER> <DATA>)
     * </br>• 2 - Transmit System Character and Country Code (“0” for USA)
     * (< COUNTRY CODE> <SYSTEM CHARACTER> <DATA>)
     * </br>• 0 - Transmit no preamble (<DATA>)
     */
    public final static int UPCA_SEND_SYS = 0x0503;
    /**
     * When UPC-A Converted to EAN-13 is selected, UPC-A bar codes are converted to 13 digit EAN-13 codes by adding a
     * zero to the front. When Do not Convert UPC-A is selected, UPC-A codes are read as UPC-A.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int UPCA_TO_EAN13 = 0x0504;

    //
    // UPC-E definitions
    //
    /**
     * This property specifies whether UPC-E decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int UPCE_ENABLE = 0x0508;
    /**
     * The check digit is the last character of the symbol used to verify the integrity of the data. Select whether to
     * transmit the bar code data with or without the UPC-E check digit. It is always verified to guarantee the integrity
     * of the data.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int UPCE_SEND_CHECK = 0x0509;
    /**
     * Preamble characters are part of the UPC symbol, and include Country Code and System Character. There are
     * three options for transmitting a UPC-E preamble to the host device. Select the appropriate option to match the
     * host system.
     * </br>• *1 - Transmit System Character Only (<SYSTEM CHARACTER> <DATA>)
     * </br>• 2 - Transmit System Character and Country Code (“0” for USA)
     * (< COUNTRY CODE> <SYSTEM CHARACTER> <DATA>)
     * </br>• 0 - Transmit no preamble (<DATA>)
     */
    public final static int UPCE_SEND_SYS = 0x050A;
    /**
     * Enable this to convert UPC-E (zero suppressed) decoded data to UPC-A format before transmission. After
     * conversion, the data follows UPC-A format and is affected by UPC-A programming selections (e.g., Preamble,
     * Check Digit). When disabled, UPC-E decoded data is transmitted as UPC-E data, without conversion.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int UPCE_TO_UPCA = 0x050B;
    /**
     * This property specifies whether UPC-E1 decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int UPCE1_ENABLE = 0x050C;
    /**
     * The check digit is the last character of the symbol used to verify the integrity of the data. Select whether to
     * transmit the bar code data with or without the UPC-E1 check digit. It is always verified to guarantee the
     * integrity of the data.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int UPCE1_SEND_CHECK = 0x050D;
    /**
     * Preamble characters are part of the UPC symbol, and include Country Code and System Character. There are
     * three options for transmitting a UPC-E1 preamble to the host device. Select the appropriate option to match
     * the host system.
     * </br>• *1 - Transmit System Character Only (<SYSTEM CHARACTER> <DATA>)
     * </br>• 2 - Transmit System Character and Country Code (“0” for USA)
     * (< COUNTRY CODE> <SYSTEM CHARACTER> <DATA>)
     * </br>• 0 - Transmit no preamble (<DATA>)
     */
    public final static int UPCE1_SEND_SYS = 0x050E;
    /**
     * Enable this to convert UPC-E1 decoded data to UPC-A format before transmission. After conversion, the data
     * follows UPC-A format and is affected by UPC-A programming selections (e.g., Preamble, Check Digit). When
     * disabled, UPC-E1 decoded data is transmitted as UPC-E1 data, without conversion.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int UPCE1_TO_UPCA = 0x050F;
    //
    // EAN-13 definitions
    //
    /**
     * This property specifies whether EAN-13 decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int EAN13_ENABLE = 0x0510;
    /**
     * This property specifies Enable or disable Bookland EAN.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int EAN13_BOOKLANDEAN = 0x0514;//BOOKLANDEAN
    /**
     * select one of the following
     * formats for Bookland data:
     * </br>• *0 - Bookland ISBN-10 - The decoder reports Bookland data starting with 978 in traditional 10-digit
     * format with the special Bookland check digit for backward-compatibility. Data starting with 979 is not
     * considered Bookland in this mode.
     * </br>• 1 - Bookland ISBN-13 - The decoder reports Bookland data (starting with either 978 or 979) as EAN-13
     * in 13-digit format to meet the 2007 ISBN-13 protocol.
     */
    public final static int EAN13_BOOKLAND_FORMAT = 0x0515;//df 0x00 ISBN-10;0x01 ISBN-13
    /**
     * This property specifies whether transmit EAN-13 check digit.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int EAN13_SEND_CHECK = 0x0516;
    //
    // EAN-8 definitions
    //
    /**
     * This property specifies whether EAN-8 decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int EAN8_ENABLE = 0x0518;
    /**
     * This property specifies whether transmit EAN-8 check digit.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int EAN8_SEND_CHECK = 0x0519;
    /**
     * Enable this parameter to add five leading zeros to decoded EAN-8 symbols to make them compatible in format
     * to EAN-13 symbols.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int EAN8_TO_EAN13 = 0x051B;//EAN-8 Zero Extend

    //
    // UPC/EAN Extensions definitions
    //
    /**
     * This parameter determines whether or not EAN supplemental 2/5 should be transmitted.
     * </br>Valid Values:
     * </br> *0 - 2/5-character addenda disable
     * </br> 1 - 2/5-character addenda enable
     */
    public final static int EAN_EXT_ENABLE_2_5_DIGIT = 0x051C;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * Enable or disable decoding UPC bar codes with reduced quiet zones.
     * </br>Valid Values:
     * </br> *0 - Disable UPC Reduced Quiet Zone
     * </br> 1 - Enable UPC Reduced Quiet Zone
     */
    public static final int UCC_REDUCED_QUIET_ZONE =  0x051A;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * Traditional coupon symbols (old coupon symbols) are composed of two bar codes: UPC/EAN and Code128. A
     * new coupon symbol is composed of a single Databar Expanded bar code.
     * </br>Select one of the following options for decoding coupon symbols:
     * </br>• 0 - Old Coupon Symbols - Scanning an old coupon symbol reports both UPC and Code 128, scanning an
     * interim coupon symbol reports UPC, and scanning a new coupon symbol reports nothing (no decode).
     * </br>• *1 - New Coupon Symbols - Scanning an old coupon symbol reports either UPC or Code 128, and
     * scanning an interim coupon symbol or a new coupon symbol reports Databar Expanded.
     * </br>• 2 - Both Coupon Formats - Scanning an old coupon symbol reports both UPC and Code 128, and
     * scanning an interim coupon symbol or a new coupon symbol reports Databar Expanded.
     */
    public static final int UCC_COUPON_EXT_REPORT_MODE = 0x0607;
    //
    /**
     * @deprecated {@link #EAN8_TO_EAN13}
     * Enable this parameter to add five leading zeros to decoded EAN-8 symbols to make them compatible in format
     *  to EAN-13 symbols.
     */
    public static final int UCC_EAN_ZERO_EXTEND = 0x0606;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * Supplementals are bar codes appended according to specific format conventions (e.g., UPC A+2, UPC E+2, EAN 13+2). Select one of the following options:
     * {@link #EAN_EXT_ENABLE_2_5_DIGIT}
     */
    public static final int UCC_EAN_SUPPLEMENTAL_MODE = 0x0605;
    /**
     * @deprecated
     * To set  Scanner linear code type security level.{@link #LINEAR_CODE_TYPE_SECURITY_LEVEL}
     * </br>Parameters Values:
     * </br>min       0
     * </br>max       3
     * </br>Default   1
     */
    public final static int UPC_EAN_SECURITY_LEVEL = 0x051D;//0 1 2 3
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * Enable this parameter to decode UPC-A bar codes starting with digit ‘5’, EAN-13 bar codes starting with digit
     * ‘99’, and UPC-A/EAN-128 Coupon Codes. UPCA, EAN-13, and EAN-128 must be enabled to scan all
     * types of Coupon Codes.{@link #UCC_COUPON_EXT_REPORT_MODE}
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int UCC_COUPON_EXT_CODE= 0x051F;

    //
    // MSI definitions
    //
    /**
     * This property specifies whether MSI decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int MSI_ENABLE = 0x0608;
    /**
     * With MSI symbols, one check digit is mandatory and always verified by the reader. The second check digit is
     * optional. If the MSI codes include two check digits, select Two MSI Check Digits to enable verification of the
     * second check digit.
     * </br>Valid Values:
     * </br>*0 - One MSI Check Digit
     * </br>1 - Two MSI Check Digits
     */
    public final static int MSI_REQUIRE_2_CHECK = 0x060A;
    /**
     * Select whether to transmit MSI data with or without the check digit.
     * </br>Valid Values:
     * </br>*0 - Do Not Transmit MSI Check Digit(s) (Disable)
     * </br>1 - Transmit MSI Check Digit(s) (Enable)
     */
    public final static int MSI_SEND_CHECK = 0x060B;
    /**
     * Select one of two algorithms for the verification of the second MSI check digit.
     * </br>Valid Values:
     * </br>*1 - MOD 10/MOD 10
     * </br>0 - MOD 10/MOD 11
     */
    public final static int MSI_CHECK_2_MOD_11 = 0x060C;
    /**
     * Set minimun length for MSI.Range: 0..55.Default = 4.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int MSI_LENGTH1 = 0x0624;
    /**
     * Set maximun length for MSI.Range: 0..55.Default = 55.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int MSI_LENGTH2 = 0x0625;

    //
    // RSS-14 definitions
    //
    /**
     * This property specifies whether GS1 DataBar-14 decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int GS1_14_ENABLE = 0x0800;
    /**
     * This parameter only applies to GS1 DataBar-14 and GS1 DataBar Limited symbols not decoded as part of a
     * Composite symbol. Enable this to strip the leading 010 from GS1 DataBar-14 and GS1 DataBar Limited
     * symbols encoding a single zero as the first digit, and report the bar code as EAN-13.
     * For bar codes beginning with two or more zeros but not six zeros, this parameter strips the leading'0100 and
     * reports the bar code as UPC-A. The UPC-A Preamble parameter that transmits the system character and
     * country code applies to converted bar codes. Note that neither the system character nor the check digit can be
     * stripped.
     * </br>Valid Values:
     * </br>• *0 - Disable Convert GS1 DataBar to UPC/EAN
     * </br>• 1 - Enable Convert GS1 DataBar to UPC/EAN
     */
    public final static int GS1_14_TO_UPC_EAN = 0x0801;

    //
    // RSS Limited definitions
    //
    /**
     * This property specifies whether GS1 DataBar Limited decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int GS1_LIMIT_ENABLE = 0x0808;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * There are four levels of decode security for GS1 DataBar Limited bar codes. There is an inverse relationship
     * between security and scanner aggressiveness. Increasing the level of security may result in reduced
     * aggressiveness in scanning, so only choose the level of security necessary.
     * </br> • 1 - Level 1 – No clear margin required. This complies with the original GS1 standard, yet might result in
     * erroneous decoding of the DataBar Limited bar codes when scanning some UPC symbols that start with
     * the digits “9” and “7” .
     * </br>• 2 - Level 2 – Automatic risk detection. This level of security may result in erroneous decoding of DataBar
     * Limited bar codes when scanning some UPC symbols. If a misdecode is detected, the scanner operates
     * in Level 3 or Level 1.
     * </br>• *3 - Level 3 – Security level reflects newly proposed GS1 standard that requires a 5X trailing clear
     * margin.
     * </br>• 4 - Level 4 – Security level extends beyond the standard required by GS1. This level of security requires
     * a 5X leading and trailing clear margin.
     */
    public final static int GS1_LIMIT_Security_Level = 0x0809;
    //
    // RSS Expanded definitions
    //
    /**
     * This property specifies whether GS1 DataBar Expanded decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int GS1_EXP_ENABLE = 0x0810;
    /**
     * Set minimun length for GS1 DataBar Expanded.Range: 0..55.Default = 1.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int GS1_EXP_LENGTH1 = 0x0824;
    /**
     * Set maximun length for GS1 DataBar Expanded.Range: 0..80. Default = 74.
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int GS1_EXP_LENGTH2 = 0x0825;

    //
    // Postal Code definitions
    //
    /**
     * This property specifies whether US Postnet/US Postal decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int US_POSTNET_ENABLE = 0x0910;
    /**
     * This property specifies whether US Planet decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int US_PLANET_ENABLE = 0x0911;
    /**
     * Select whether to transmit US Postal data, which includes both US Postnet and US Planet, with or without the
     * check digit.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int US_POSTAL_SEND_CHECK = 0x0912;
    /**
     * This property specifies whether USPS 4CB/One Code/Intelligent Mail(US Postal (Intelligent Mail)) decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int USPS_4STATE_ENABLE = 0x0913;
    /**
     * This property specifies whether UPU FICS Postal(US4State FISC/UPU ID-Tag/US Postal) decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int UPU_FICS_ENABLE = 0x0914;
    /**
     * This property specifies whether ROYAL mail (InfoMail, Customer Code)(BPO 4-state) decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int ROYAL_MAIL_ENABLE = 0x0915;
    /**
     * @deprecated Select whether to transmit royal mail data with or without the check digit.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int ROYAL_MAIL_SEND_CHECK = 0x0916;
    /**
     * This property specifies whether Australia Post decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int AUSTRALIAN_POST_ENABLE = 0x0917;
    /**
     * This property specifies whether Netherlands KIX Code(Dutch Post) decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int KIX_CODE_ENABLE = 0x0918;
    /**
     * This property specifies whether Japan Postal decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int JAPANESE_POST_ENABLE = 0x0919;
    /**
     * This property specifies whether Korea Postal decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int KOREA_POST_ENABLE = 0x091a;//0x0920;

    /**
     * </br>This property specifies whether Canadian Postal decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int Canadian_POSTAL_ENABLE= 0x0922;

    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * </br>When enabling Postal Symbologies, only certain combinations are allowed. Postal symbology decoding is enabled according to
     * the table below. Table entries may not be combined (i.e., summed) to enable multiple symbologies, unless the combination is
     * explicitly shown below:
     * </br>• *0 - Used to disable all postal symbologies
     * </br>• 1 -Australian Post decoding enabled.
     * </br>• 2 -Royal Mail 4 State Customer Code (British Post Office) decoding enabled.
     * </br>• 3 -Japan Post decoding enabled.
     * </br>• 4 -KIX Code(dutch post) decoding enabled.
     * </br>• 5 -Planet decoding enabled.
     * </br>• 6 -Postent decoding enabled.
     * </br>• 7 -UPU decoding enabled.
     * </br>• 8 -USPS 4CB decoding enabled.
     * </br>• 9 -Canadian post.
     * </br>• 10 -Planet and Postent.
     * </br>• 11 -Postent and UPU.
     * </br>• 12 -Planet and USPS 4CB.
     * </br>• 13 -Postent and USPS 4CB.
     * </br>• 14 -UPU and USPS 4CB.
     * </br>• 15 -Planet and Postent, UPU.
     * </br>• 16 -Planet and Postent,USPS 4CB.
     * </br>• 17 -Planet and UPU,USPS 4CB.
     * </br>• 18 -Postent and UPU,USPS 4CB.
     * </br>• 19 -Planet and Postent, UPU,USPS 4CB.
     */
    public final static int POSTAL_GROUP_TYPE_ENABLE= 0x0921;
    //
    // PDF417 definitions
    //
    /**
     * This property specifies whether PDF417 decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int PDF417_ENABLE = 0x0A00;
    //
    // MicroPDF417 definitions
    //
    /**
     * This property specifies whether MicroPDF417 decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int MICROPDF417_ENABLE = 0x0A08;
    //
    // Composite Code definitions
    //
    /**
     * This property specifies whether Composite CC-A/B decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int COMPOSITE_CC_AB_ENABLE  = 0x0A30;
    /**
     * This property specifies whether Composite CC-C decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int COMPOSITE_CC_C_ENABLE   = 0x0A40;
    /**
     * This property specifies whether Composite TLC-39 decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int COMPOSITE_TLC39_ENABLE = 0x0A41;
    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     *
     * Select an option for linking UPC symbols with a 2D symbol during transmission as if they were one symbol:
     * </br>• 1 - UPC Always Linked - transmit UPC bar codes and the 2D portion.
     * If 2D is not present, the UPC bar code does not transmit.
     * </br>• *0 - UPC Never Linked - transmit UPC bar codes regardless of whether a 2D symbol is detected.
     * </br>• 2 - Autodiscriminate UPC Composites - the imager engine determines if there is a 2D portion, then
     * transmits the UPC, as well as the 2D portion if present.
     */

    public final static int COMPOSITE_UPC_MODE  = 0x0A39;
    /**
     * This property specifies whether Han Xin decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public static final int HANXIN_ENABLE =  0x0A42;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Zebra scanner.
     * </br>Set the Han Xin inverse decoder setting:
     * </br>• *0 - Regular Only - the decoder decodes Han Xin bar codes with normal reflectance only.
     * </br>• 1 - Inverse Only - the decoder decodes Han Xin bar codes with inverse reflectance only.
     * </br>• 2 - Inverse Autodetect - the decoder decodes both regular and inverse Han Xin bar codes.
     */
    public static final int HANXIN_INVERSE =  0x0A43;
    //
    // DataMatrix definitions
    //
    /**
     * This property specifies whether DataMatrix decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int DATAMATRIX_ENABLE = 0x0B00;
    /**
     * @deprecated
     * Set minimun length for DataMatrix.Range: 1..3166
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int DATAMATRIX_LENGTH1 = 0x0B20;
    /**
     * @deprecated
     * Set maximun length for DataMatrix.Range: 1..3166
     * The length of a code refers to the number of characters (i.e., human readable characters), including check
     * digit(s) the code contains
     */
    public final static int DATAMATRIX_LENGTH2 = 0x0B21;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Zebra scanner.
     * </br>Set the DataMatrix inverse decoder setting:
     * </br>• *0 - Regular Only - the decoder decodes DataMatrix bar codes with normal reflectance only.
     * </br> • 1 - Inverse Only - the decoder decodes DataMatrix bar codes with inverse reflectance only.
     * </br> • 2 - Inverse Autodetect - the decoder decodes both regular and inverse DataMatrix bar codes.
     */

    public final static int DATAMATRIX_INVERSE = 0x0B22;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This property can improve decoding Data Matrix symbols when the length of a symbol side is small.
     * </br>The property value should be set as follows:
     * </br>*0: Normal Data Matrix operation.
     * </br>1: Handle smaller Data Matrix symbols.
     * </br>2: Handle very small Data Matrix symbols.
     */
    public final static int DATAMATRIX_SYMBOL_SIZE = 103;
    //
    // MaxiCode definitions
    //
    /**
     * This property specifies whether MaxiCode decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int MAXICODE_ENABLE = 0x0B08;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This property can improve decoding Maxicode symbols when the length of a symbol side is small.
     * </br>The property value should be set as follows:
     * </br>*0: Normal Maxicode operation.
     * </br>1: Handle smaller Maxicode symbols.
     */
    public final static int MAXICODE_SYMBOL_SIZE = 102;

    //
    // QR Code definitions
    //
    /**
     * This property specifies whether QR Code decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int QRCODE_ENABLE = 0x0B10;
    /**
     * This property specifies whether MicroQR Code decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int MICROQRCODE_ENABLE = 0x0B14;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Zebra scanner.
     * </br> Set the QR Code inverse decoder setting:
     * </br>• *0 - Regular Only - the decoder decodes QR Code bar codes with normal reflectance only.
     * </br>• 1 - Inverse Only - the decoder decodes QR Code bar codes with inverse reflectance only.
     * </br>• 2 - Inverse Autodetect - the decoder decodes both regular and inverse QR Code bar codes.
     */
    public final static int QRCODE_INVERSE = 0x0B15;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This property can improve decoding QR Code or Micro QR Code symbols when the length of a symbol side is small.
     * </br>The property value should be set as follows:
     * </br>*0: Normal QR Code and Micro QR Code operation.
     * </br>1: Handle smaller QR Code and Micro QR Code symbols.
     */
    public final static int QRCODE_SYMBOL_SIZE = 100;

    //
    // Aztec Code definitions
    //
    /**
     * This property specifies whether Aztec Code decoding is enabled.
     * </br>Valid Values:
     * </br> 0 - Disable
     * </br> *1 - Enable
     */
    public final static int AZTEC_ENABLE = 0x0B18;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Zebra scanner.
     * </br>Set the Aztec Code inverse decoder setting:
     * </br>• *0 - Regular Only - the decoder decodes Aztec Code bar codes with normal reflectance only.
     * </br>• 1 - Inverse Only - the decoder decodes Aztec Code bar codes with inverse reflectance only.
     * </br>• 2 - Inverse Autodetect - the decoder decodes both regular and inverse Aztec Code bar codes.
     */
    public final static int AZTEC_INVERSE = 0x0B19;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This property enables the detection of smaller Aztec symbols. The decoder processing time may be increased
     * when this property is enabled.
     * </br>The property value should be set as follows:
     * </br>*0: Normal Aztec operation.
     * </br>1: Handle smaller Aztec symbols.
     */
    public final static int AZTEC_SYMBOL_SIZE = 101;
    /**
     * This property specifies whether Dot code decoding is enabled.
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public final static int DOTCODE_ENABLE = 0x0B09;

    /**
     * This property specifies whether the lights mode settings.
     * </br>Valid Values:
     * <table border=2>
     *  <tr><td>*0</td><td>Neither aimer or illumination</td></tr>
     *  <tr><td>1</td><td>Aimer only </td></tr>
     *  <tr><td>2</td><td>Illumination only</td></tr>
     *  <tr><td>3</td><td>Aimer and illumination alternating</td></tr>
     *  <tr><td>4</td><td>Both aimer and illumination</td></tr>
     *  </table>
     */
    public static final int DEC_2D_LIGHTS_MODE= 0x0B23;
    /**
     * This property specifies whether Centering mode decoding is enabled.
     * Use Centering to narrow the scan engine’s field of view to make sure that when the scanner is hand-held, it reads only those bar
     * codes intended by the user
     * </br>Valid Values:
     * </br> *0 - Disable
     * </br> 1 - Enable
     */
    public static final int DEC_2D_CENTERING_ENABLE= 0x0B24;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * Decode Window Mode setting. Limits that are allowed to be specified.
     * {@link #DEC_2D_CENTERING_ENABLE} must be enabled for this parameter to function.
     * </br>Valid Values:
     * <table border=2>
     *  <tr><td>*0</td><td>Disables Decode Window</td></tr>
     *  <tr><td>1</td><td> Window around aimer (center of image must be covered, since the aimer coordinates offset the window from center) </td></tr>
     *  <tr><td>2</td><td>Window as defined in field of view</td></tr>
     *  <tr><td>3</td><td>Picklist Mode</td></tr>
     *  </table>
     */
    public static final int DEC_2D_CENTERING_MODE= 0x0B25;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * Decode Window coordinate settings.  Rectangular image
     * region of which at least part of the decoded symbol must overlap to
     * be considered a valid decode (excluding nMode = 3, which means that
     * the entire barcode must be contained within the window)
     * Upper left X coordinate setting : default  290, min    0, max   319
     * {@link #DEC_2D_CENTERING_MODE} must be set field of view mode for this parameter to function.
     */
    public static final int DEC_2D_WINDOW_UPPER_LX= 0x0B26;
    /**
     *@deprecated Upper left Y coordinate setting :default  350, min  320, max   639
     * </br>{@link #DEC_2D_WINDOW_UPPER_LX}
     * </br>{@link #DEC_2D_CENTERING_MODE} must be set field of view mode for this parameter to function.
     */
    public static final int DEC_2D_WINDOW_UPPER_LY= 0x0B27;
    /**
     *@deprecated Upper right X coordinate setting : default  386, min    0, max   415
     * </br>{@link #DEC_2D_WINDOW_UPPER_LX}
     * </br>{@link #DEC_2D_CENTERING_MODE} must be set field of view mode for this parameter to function.
     */
    public static final int DEC_2D_WINDOW_LOWER_RX= 0x0B28;
    /**
     *@deprecated
     * Upper right Y coordinate setting : default  446, min  416, max   831
     * </br>{@link #DEC_2D_WINDOW_UPPER_LX}
     * </br>{@link #DEC_2D_CENTERING_MODE} must be set field of view mode for this parameter to function.
     */
    public static final int DEC_2D_WINDOW_LOWER_RY= 0x0B29;
    /**
     *@deprecated Parameters no longer used
     */
    public static final int DEC_2D_DEBUG_WINDOW_ENABLE= 0x0B30;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * Exposure method to use
     * Valid Values: Rang[0-2]
     * */
    public static final int DEC_ES_EXPOSURE_METHOD = 0x0A09;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * Target white value in image to try and achieve
     * Valid Values: Rang[1-255]
     * */
    public static final int DEC_ES_TARGET_VALUE = 0x0A10;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * The percentile the white target value should be at
     * Valid Values: Rang[1-99]
     * */
    public static final int DEC_ES_TARGET_PERCENTILE = 0x0A11;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * How close to the target while value must image be
     * Valid Values: Rang[1-50]
     * */
    public static final int DEC_ES_TARGET_ACCEPT_GAP = 0x0A12;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This is the maximum exposure allowed to use
     * Valid Values: Rang[1-7874]
     * */
    public static final int DEC_ES_MAX_EXP = 0x0A13;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This is the maximum gain allowed to use
     * Valid Values: Rang[1-4]
     * */
    public static final int DEC_ES_MAX_GAIN = 0x0A14;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * Frame rate to use - fixed cannot be changed
     * Valid Values: Rang[1-30]
     * */
    public static final int DEC_ES_FRAME_RATE = 0x0A15;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * The image must conform to the auto-exposure requirements, if not, it's rejected
     * Valid Values: Rang[0-1]
     * */
    public static final int DEC_ES_CONFORM_IMAGE = 0x0A16;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * The number of time it will attempt to conform
     * Valid Values: Rang[1-8]
     * */
    public static final int DEC_ES_CONFORM_TRIES = 0x0A17;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * Specular exclusion value to use
     * Valid Values: Rang[0-4]
     * */
    public static final int DEC_ES_SPECULAR_EXCLUSION = 0x0A18;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * If specular exclusion is set, what is the saturation value
     * Valid Values: Rang[200-255]
     * */
    public static final int DEC_ES_SPECULAR_SAT = 0x0A19;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * If specular exclusion is set, what is the limit
     * Valid Values: Rang[1-5]
     * */
    public static final int DEC_ES_SPECULAR_LIMIT = 0x0A20;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * If exposure mode is FIXED, what is the exposure
     * Valid Values: Rang[1-7874]
     * */
    public static final int DEC_ES_FIXED_EXP = 0x0A21;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * If exposure mode is FIXED, what is the gain
     * Valid Values: Rang[1-4]
     * */
    public static final int DEC_ES_FIXED_GAIN = 0x0A22;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * If exposure mode is FIXED, what is the frame rate (fixed, has no effect)
     * Valid Values: Rang[1-30]
     **/
    public static final int DEC_ES_FIXED_FRAME_RATE = 0x0A23;

    /**
     * <p>Note: The property value below is only supported on platforms interfacing to the Zebra scanner.
     * This parameter sets the level of illumination by altering laser/LED power. The default is 10, which is maximum
     * illumination. For values from 0 to 10, illumination varies from lowest to highest level. This parameter affects
     * both decoding and motion illumination.
     */
    public static final int DEC_ILLUM_POWER_LEVEL = 0x0A24;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell 3680 scanner.
     * This feature allows you to turn the aimer on and off. When the Interlaced bar code is scanned, the aimer is interlaced with the
     * illumination LEDs
     */
    public static final int DEC_PICKLIST_AIM_MODE = 0x0A25;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell 3680 scanner.
     * The aimer delay allows a delay time for the operator to aim the scan engine before the picture is taken. Use these codes to set
     * the time between when the trigger is pulled and when the picture is taken. During the delay time, the aiming light will appear,
     * but the LEDs won’t turn on until the delay time is over. Default = Off.
     */
    public static final int DEC_PICKLIST_AIM_DELAY = 0x0A26;
    /**
     * The parameter Set the buffer length for continuous scanning without repeated decoding.
     * The value range is 2 to 100;
     * {@link #DEC_Multiple_Decode_MODE}
     */
    public static final int DEC_MaxMultiRead_COUNT= 0x0A27;
    /**
     * Use this option in presentation mode to prevent multiple reads of a symbol left in the imager engine’s field of view.
     * The timeout begins when you remove the symbol from the field of view.
     * </br>Valid Values: Rang[50-60000] ms. Default = 5000 ms.
     */
    public static final int DEC_Multiple_Decode_TIMEOUT= 0x0A28;
    /**
     * The parameter Set continuous scanning without repeated decoding.
     * {@link #TRIGGERING_MODES} must be set CONTINUOUS mode
     * </br>Valid Values:
     * </br>*0 Always allow duplicate
     * </br>1 Allow duplicate only after the specified time out
     * </br>2 Allow duplicate outside the scope of the list
     */
    public static final int DEC_Multiple_Decode_MODE= 0x0A29;
    /**
     * Use this option in presentation mode to prevent multiple reads of a symbol left in the imager engine’s field of
     * view. The timeout begins when you remove the symbol from the field of view.
     * {@link #TRIGGERING_MODES} must be set CONTINUOUS mode.
     * </br>Valid Values: Rang[0-5000] ms. Default = 50 ms.
     */
    public static final int DEC_Multiple_Decode_INTERVAL= 0x0A2A;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     *  Amount of time decoder will spend on each image.
     *  Valid Values: Rang[50-800] ms
     */
    public static final int DEC_EachImageAttempt_TIME= 0x0A2B;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This property specifies the mode settings.
     * </br>Valid Values:
     * <table border=2>
     *  <tr><td>0*</td><td>OCR Disabled</td></tr>
     *  <tr><td>1</td><td>OCR Normal Video (black high) </td></tr>
     *  <tr><td>2</td><td>OCR Inverse Video (white high)</td></tr>
     *  <tr><td>3</td><td>OCR Both Video (white & black high)</td></tr>
     *  </table>
     */
    public static final int DEC_OCR_MODE =  0x0A44;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell  scanner.
     * This property specifies the OCR predefined templates.
     * </br>Valid Values:
     * <table border=2>
     *  <tr><td>1*</td><td> OCR User Template</td></tr>
     *  <tr><td>2</td><td> OCR Passport Template </td></tr>
     *  <tr><td>4</td><td> OCR ISBN Template</td></tr>
     *  <tr><td>8</td><td> OCR Price Field Template</td></tr>
     *  <tr><td>10</td><td> OCR Micre13B Template</td></tr>
     *  </table>
     */
    public static final int DEC_OCR_TEMPLATE =  0x0A45;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell  scanner.
     * Custom OCR Templates are strings made up of various control codes, along with standard ASCII values.
     * Quick Reference:
     * </br> 1 - New Template followed by (1:OCR-A, 2:OCR-B, 3:OCR-A or B, 4:MICR, 5:SEMI)
     * </br> 2 - New Line
     * </br> 5 - Numeric Wildcard
     * </br> 6 - Alpha Wildcard
     * </br> 7 - Alphanumeric Wildcard
     * </br> 8 - Any Char Wildcard
     * </br> 0 - End of Template
     * </br> Example (Eight alphanumeric OCR-A or OCR-B chars): 13777777770
     */
    public static final int DEC_OCR_USER_TEMPLATE =  0x0A46;
    /**
     * @deprecated
     * Reserved.Interface not implemented.Ignore this property for any scanner.
     */
    public static final int DEC_DECODE_DELAY = 0x0C01;
    /**
     * @deprecated
     * Reserved.Interface not implemented.Ignore this property for any scanner.
     */
    public static final int DEC_DECODE_DEBUG_MODE = 0x0C02;
    /**
     * This property specifies whether overwrite content in edit box.
     * </br>Valid Values:
     * </br>• *0 - appends.
     * </br>• 1 -overwrite.
     */
    public static final int OUT_EDITORTEXT_MODE= 0x0A31;
    /**
     * This property specifies whether Clipboard mode is enabled.
     * </br>Valid Values:
     * </br>• *0 - disable.
     * </br>• 1 - enable.
     */
    public static final int OUT_CLIPBOARD_ENABLE= 0x0A32;
    /**
     * @deprecated This property specifies whether Clipboard mode paste is enabled.
     */
    public static final int OUT_CLIPBOARD_PASTE_ENABLE= 0x0A36;
    //
    // Wedge - Keyboard and Intent mode
    //
    /**
     * This property specifies whether Keyboard mode is enabled.
     *  </br>Valid Values:
     * </br>• 0 - Intent output.
     * </br>• *1 - Auto append text to TextBox or IME keyboard.
     * </br>• 2 - Intent output and Keyboard event.
     */
    public final static int WEDGE_KEYBOARD_ENABLE = 0x11170;
    /**
     * This property specifies select an option for keystroke types:
     * </br>Valid Values:
     * </br>• *0 - Auto append text to TextBox.
     * </br>• 1 - Auto append text to TextBox or IME keyboard.
     * </br>• 2 - Always Physical.
     * </br>• 3 - Always IME keyboar.
     */
    public final static int WEDGE_KEYBOARD_TYPE = 0x11171;
    /**
     * @deprecated
     * Reserved.{@link #WEDGE_KEYBOARD_ENABLE} This property specifies whether intent output mode is enabled.
     */
    public final static int WEDGE_INTENT_ENABLE = 0x11172;
    /**
     *In the Intent output plug-in configuration, the Intent action would be default value: {@link android.device.ScanManager#ACTION_DECODE}
     */
    public final static int WEDGE_INTENT_ACTION_NAME = 0x30D40;
    /**
     * @deprecated Reserved.The decode related label type id added to the Intent’s bundle can be retrieved using the Intent.getIntExtra() calls.
     */
    public final static int WEDGE_INTENT_LABEL_TYPE_TAG = 0x30D41;
    /**
     *The decode related data added to the Intent’s bundle can be retrieved using the Intent.getStringtExtra() calls, using the following String tags default value: {@link android.device.ScanManager#BARCODE_STRING_TAG}
     */
    public final static int WEDGE_INTENT_DATA_STRING_TAG = 0x30D42;
    /**
     * Can output acquired data in its raw form, before the application of any encoders. This can be useful if custom encoders are needed for acquiring character sets not supported by ScanWedge.
     *The decode related data added to the Intent’s bundle can be retrieved using the Intent.getByteArrayExtra() calls, using the following String tags default value: {@link android.device.ScanManager#DECODE_DATA_TAG}
     */
    public final static int WEDGE_INTENT_DECODE_DATA_TAG = 0x30D43;
    /**
     * @deprecated Reserved.
     * Receiver foreground flag Intent.FLAG_RECEIVER_FOREGROUND can be set giving the broadcast recipient permission to run at foreground priority with a shorter timeout interval.
     */
    public final static int WEDGE_INTENT_FOREGROUND_FLAG = 0x30D37;
    /**
     * Add a new category to the intent.  Categories provide additional detail
     * about the action the intent performs.  When resolving an intent, only
     * activities that provide <em>all</em> of the requested categories will be used.
     * @deprecated Reserved.specifies the category of intent to be handled.
     * </br>Property is String Data Type.Example: "android.intent.category.DEFAULT"
     */
    public static final int WEDGE_INTENT_CATEGORY_NAME = 0x30D38;
    /**
     * (Usually optional) Set an explicit application package name that limits
     * the components this Intent will resolve to.  If left to the default
     * value of null, all components in all applications will considered.
     * If non-null, the Intent can only match the components in the given
     * application package.
     */
    public static final int WEDGE_INTENT_PACKAGE_NAME = 0x30D39;
    /**
     * @deprecated Reserved.
     * Used to select one of four delivery methods for intent-based data:
     * </br>• 0 Send via startService - startService() Android API is called to deliver data for devices prior to Android Oreo (v8.0). For Android Oreo and above devices, the option "Use startForegroundService on failure" is available within this setting to call startForegroundService() if the startService() call fails. With this single option, it provides support for devices both prior and later than Android Oreo.
     * {@link #WEDGE_INTENT_FOREGROUND_FLAG} Send via startForegroundService - startForegroundService() Android API is called to deliver data. This option applies to Android Oreo (v8.0) and above.
     * </br>• 1 Send via startActivity - startActivity() Android API is called to deliver data.
     * </br>• *2 Broadcast Intent - Receiver foreground flag Intent.FLAG_RECEIVER_FOREGROUND can be set giving the broadcast recipient permission to run at foreground priority with a shorter timeout interval.
     */
    public static final int WEDGE_INTENT_DELIVERY_MODE = 0x30D36;
    /**
     *This property specifies whether floating button mode is enabled.
     * </br>Valid Values:
     * </br>• *0 - disable.
     * </br>• 1 - enable.
     */
    public final static int SUSPENSION_BUTTON = 0x02018;
    /**
     *@deprecated Reserved.This property specifies whether handle button mode is enabled.
     * </br>Valid Values:
     * </br>• *0 - disable.
     * </br>• 1 - enable.
     */
    public final static int SCAN_HANDLE = 0x02019;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     *
     * </br>This property specifies whether group seperator is ignore.
     * </br>This feature applies to decoder bar codes with an embedded group seperator(HEX 1D) character.
     * </br>Valid Values:
     * </br>• *0 - disable.
     * </br>• 1 - enable.
     */
    public final static int SPECIFIC_CODE_GS = 0x1a014006;
    /**
     * @deprecated This property specifies whether cache the bar data is enabled.
     */
    public static final int CACHE_DATA_ENABLE=  0x0A33;
    /**
     * @deprecated This property specifies whether cache the bar data limit time is enabled.
     */
    public static final int CACHE_DATA_LIMIT_ENABLE=  0x0A34;
    /**
     * @deprecated
     *Set the maximum time decode processing continues cache the bar data, available in 0.1 second increments
     * from 3000ms to 60000ms. The default timeout is 3000ms.
     */
    public static final int CACHE_DATA_LIMIT_TIME=  0x0A35;
    /**
     * @deprecated
     * Reserved.Interface not implemented.
     */
    public static final int LOW_POWER_SLEEP_MODE=  104;
    /**
     * @deprecated
     * Reserved.Interface not implemented.
     */
    public static final int LOW_POWER_SLEEP_TIMEOUT=  105;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * </br>Controls low contrast searching.The property value is a bit field defined as follow:
     * </br>*0:All special low contrast algorithms are disabled
     * </br>1: Enable improved locating for low contrast linear symbols (including PDF417 and MicroPDF417) - note 1
     * </br>2: Enable improved decoding for low contrast Interleaved 2 of 5 symbols - note 2
     * </br>3: Enable improved decoding for low contrast QR, Maxicode and Aztec
     */
    public static final int LOW_CONTRAST_IMPROVED=  106;
    /**
     * @deprecated {@link #LOW_CONTRAST_IMPROVED}
     */
    public static final int LOW_CONTRAST_IMPROVED_ALGORITHM=  107;
    /**
     * The Universal Device Identifier (UDI) parameter acquires multiple barcodes simultaneously.
     * Output of collected UDI data might require settings adjustments of the token-separation character and/or output order.
     * </br>Valid Values:
     * </br>*0: Disabled decoded with UDI
     * </br>1: Enable decoded with UDI and output UDI format data.
     * </br>2: Enable decoded with UDI, output barcode data and UDI format data.
     */
    public static final int SEND_TOKENS_OPTION=  108;
    /**
     * This property specifies UDI data output format.
     * </br>Valid Values:
     * </br>*0: String
     * </br>1: XML.
     * </br>2: JSON.
     */
    public static final int SEND_TOKENS_FORMAT=  109;
    /**
     * </br>Select valid value from the following options：
     * </br>• 0 - None
     * </br>• 1* - Carriage return
     * </br>• 2 - IME action done
     * </br>• 3 - TAB
     */
    public static final int SEND_TOKENS_SEPARATOR=  110;
    /**
     * UDI decoding is supported only on the standard code listed below.
     * <table border=2>
     *  <tr><td>62</td><td>ALL UDI Code</td></tr>
     *  <tr><td>0x0002</td><td>GS1</td></tr>
     *  <tr><td>0x0004</td><td>HIBCC</td></tr>
     *  <tr><td>0x0008</td><td>ICCBBA</td></tr>
     *  <tr><td>0x0010</td><td>MA</td></tr>
     *  <tr><td>0x0020</td><td>AHM</td></tr>
     *  </table>
     */
    public static final int ENABLE_PARSER_UDICODE=  111;
    /**
     * Convert UDI date data to yy-MM-dd format
     * </br>Property is Int Data Type. Valid Values:
     * </br>• *0 - disable.
     * </br>• 1 - enable.
     */
    public static final int ENABLE_FORMAT_UDI_DATE=  112;
    /**
     * Open browser based on web site address as the barcode data.
     * </br>Property is Int Data Type. Valid Values:
     * </br>• *0 - disable.
     * </br>• 1 - enable.
     */
    public static final int WEBJUMP = 113;
    /**
     * Enable sends the data in hexadecimal format. For example, if the acquired barcode data is 012345, this option would send the hex equivalent of 303132333435.
     * </br>Property is Int Data Type. Valid Values:
     * </br>• *0 - disable.
     * </br>• 1 - enable.
     */
    public static final int OUTPUT_HEX_STRING_DATA=  201;
    /**
     * This property specifies whether Grid Matrix decoding is enabled.
     * </br>Valid Values:
     * </br>• *0 - disable.
     * </br>• 1 - enable.
     */
    public static final int GRIDMATRIX_ENABLED=  202;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This property allows to decode QR barcodes without quiet zones.
     * </br>Property is Int Data Type. Valid Values:
     * </br>• *0 - disable.
     * </br>• 1 - enable.
     */
    public static final int QR_WITHOUT_QZ=  203;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This property can improve decoding QR Code symbols when the finder patterns are sufficiently non-square.
     * </br>The property value should be set as follows:
     * </br>0: Disable improvements for codes with non-square modules.
     * </br>1: Enable improvements for codes with non-square modules.
     */
    public static final int QR_NON_SQUARE_MODULES=  204;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * This property enables enhancements for reading difficult Code 128 bar codes during the execution of the Decode.
     * The property value is a bit field defined as follows:
     * </br>*0: disable
     * </br>1: Enable Code 128 Enhancement for reading codes whose bars have inconsistent width from top to bottom.
     * NOTE: This setting only works when DEC_USE_MLD for Code 128 is disabled. Also, this setting can affect read
     * performance when DEC_GENERAL_IMPROVEMENTS bit +2 is set.
     * </br>2: Enable Code 128 Enhancement for reading codes with extreme bar growth (i.e. over inking)
     * </br>4: Enable reading of Code 128 barcodes with Out of Spec Start patterns (1st bar is 1x). NOTE: b0 and b2 cannot
     * be activated at the same time (b0 won't work as expected).
     * </br>8: Increase the codeword to codeword length tolerance. NOTE: Using this setting can decrease reading
     * performances on low contrast or damaged barcodes.
     */
    public static final int C128_OUT_OF_SPEC=  205;
    /**
     * Select when to generate a decode event to the calling application when Multi Decode Mode is enabled.
     * {@link #TRIGGERING_MODES} must be set CONTINUOUS mode
     * {@link #DEC_Multiple_Decode_MODE} has set to 2.
     * </br>Valid Values:
     * </br> *0 - disable. clear buffer and continuous decode
     * </br> 1 - enable. stop continuous decode.
     */
    public static final int FIXED_MultiRead_COUNT=  207;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Zebra scanner.
     * Retry Count - Retry count for auto-discriminating UPC/EAN/JAN supplementals,
     * adjusting the number of times to decode a barcode without supplementals before transmission.
     * The value range is 2 to 20; default value is 10.
     */
    public static final int UCC_EAN_SUPP_Redundancy=  1540;
    /**
     *
     * The property is set to valid character encoding.
     * {@link #CODING_FORMAT}
     * </br>Property is String Data Type.Example:"ISO-8859-1"
     */
    public static final int CODING_FORMAT_NAME=  206;
    /**
     * @deprecated
     */
    public static final int DEC_MIN_ES_MAX_EXP=  208;
    /**
     * @deprecated
     */
    public static final int DEC_MAX_ES_MAX_EXP=  209;
    /**
     * @deprecated
     */
    public static final int DEC_MIN_ES_MAX_GAIN=  210;
    /**
     * @deprecated
     */
    public static final int DEC_MAX_ES_MAX_GAIN=  211;
    /**
     * @deprecated
     */
    public static final int DEC_ADJUST_ES_MAX_EXP=  212;
    /**
     * ALL 1D symbol Variable length,enable limit min length
     *
     */
    public static final int VARIABLE_LENGTH_1D_LIMIT =  213;
    /**
     *
     * The property is set to ALL 1D symbol Variable length,min length
     * {@link #VARIABLE_LENGTH_1D_LIMIT}
     */
    public static final int VARIABLE_1D_MIN_LENGTH=  214;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * </br>Valid Values:
     * </br>0: disabled
     * </br>1: no-minimum area checked
     * </br>2: requires a full specified quiet zone area to be within the image
     * </br>3: requires 2X the full specified quiet zone area to be within the image
     */
    public static final int LINEAR_BOUNDARY_CHECK=  215;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * </br>Valid Values:
     * </br>0: disabled
     * </br>1: Distance Maps for UPC
     * </br>2: Distance Maps for Code 128
     * </br>3: Distance Maps for Code 39
     * </br>4: Distance Maps for Code 128, UPC/EAN and Code39
     */
    public static final int DEC_USE_DISTANCE_MAP=  216;
    /**
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * </br>Valid Values:
     * </br>0: disabled
     * </br>1: MLD for UPC
     * </br>2: MLD for Code 128
     * </br>3: MLD for Code 39
     * </br>4: MLD for Code 128, UPC/EAN and Code39
     */
    public static final int DEC_USE_MLD=  217;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * Target white value in image to try and achieve
     * Valid Values: Rang[0-255]
     * */
    public static final int DEC_ES_TARGET_CONTRAST=  3093;
    /**
     * @deprecated
     * <p>Note: The parameter values below are only supported on platforms interfacing to the Honeywell scanner.
     * Target white value in image to try and achieve
     * Valid Values: Rang[5-22]
     * */
    public static final int DEC_ES_IMAGE_GAMMA=  61441;
}

