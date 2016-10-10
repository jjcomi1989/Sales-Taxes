package tax;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by jjcomi1989 on 10/10/16.
 */

public class Helper {
    public static float truncate(float value) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat decimalFormat = (DecimalFormat)numberFormat;
        String result = decimalFormat.format(value);
        return Float.parseFloat(result);
    }
}
