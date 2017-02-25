package rainbow.start;

import codeLinesReader.rainbow.CodeLinesReaderUser;
import rainbow.GUI.frame.MainFrameController;
import rainbow.back.BackImage;
import rainbow.coordinate.image.CoordinateSystemImage;
import rainbow.coordinate.system._abs.CoordinateSystem;
import rainbow.coordinate.system.two.axes.AxesCoordinateSystem;
import rainbow.function.FunctionsImage;
import rainbow.system.MySystem;
import rainbow.system.image.FrameImages;

/**
 * 启动类
 *
 * @author Rainbow Yang
 * @version V1.4
 */
public class Start {
    public static void main(String[] args) {
        linesCount();
        init();
    }

    public static void init() {
        MySystem ms = MySystem.createSystem();
        CoordinateSystem cs = ms.getCoordinateSystem();
        AxesCoordinateSystem acs = (AxesCoordinateSystem) cs;

        MainFrameController.init();

        FrameImages fi = new FrameImages();

        fi.add(new BackImage());
        fi.add(new CoordinateSystemImage(ms));
        fi.add(new FunctionsImage(ms));

        MainFrameController.addImage(fi);

    }

    public static void linesCount() {
        new CodeLinesReaderUser(".", CodeLinesReaderUser.SIMPLE);
    }
}
