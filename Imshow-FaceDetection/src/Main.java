import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Main {
    public static void main(String[] args)
    {
        //导入dll文件
        String dllUrl=System.getProperty("user.dir")+"\\opencv\\x64\\opencv_java341.dll";
        System.load(dllUrl);
        //读入照片
        Mat image=Imgcodecs.imread(System.getProperty("user.dir")+"\\lena.jpg");
        //人脸识别
        FaceDetect detect=new FaceDetect();
        if(detect.detect(image))
        {
            //如果识别存在人脸
            image=detect.outImage();
        }
        //显示照片
        ImageViewer viewer=new ImageViewer(image,"Test");
        viewer.imshow();
        viewer.waitKey(0);
    }
}
