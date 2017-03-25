package rainbow.start;

//import codeLinesReader.rainbow.CodeLinesReaderUser;
import rainbow.outer.frame.MainFrameController;
import rainbow.outer.back.BackImage;
import rainbow.inner.coordinate.image.CoordinateSystemImage;
import rainbow.inner.coordinate.system._abs.CoordinateSystem;
import rainbow.inner.coordinate.system.two.axes.AxesCoordinateSystem;
import rainbow.inner.function.FunctionsImage;
import rainbow.inner.system.MySystem;
import rainbow.inner.system.image.FrameImages;

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
//        new CodeLinesReaderUser(".", CodeLinesReaderUser.SIMPLE);
    }
}
