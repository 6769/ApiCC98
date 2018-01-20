import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NormalUnit {



    @Test
    public void testDateStr() throws Exception {
        String cc98="2018-01-20T11:43:33.023";
        Date newTime = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.S");
        String formatDate = dateFormatter.format(newTime);

        Date ccd=dateFormatter.parse(cc98);
        System.out.println(ccd);
    }
}
