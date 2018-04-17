import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetect {
    private String casUrl=System.getProperty("user.dir")+"\\opencv\\etc\\haarcascades\\haarcascade_frontalface_alt.xml";
    private Mat out;
    private boolean exist=false;
    private int num=0;
    public boolean detect(Mat src)
    {
        exist=false;
        num=0;
        CascadeClassifier faceDetector=new CascadeClassifier();
        //加载分类器
        faceDetector.load(casUrl);
        //用于保存监测到的人脸
        MatOfRect faceDetections=new MatOfRect();
        //开始监测
        faceDetector.detectMultiScale(src,faceDetections);
        //System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
        for(Rect rect:faceDetections.toArray())
        {
            //循环所有监测到的人脸
            Point x=new Point(rect.x,rect.y);
            Point y=new Point(rect.x+rect.width,rect.y+rect.height);
            //在src图片上画框
            Imgproc.rectangle(src,x,y,new Scalar(255,0,0),2);
            exist=true;
            num++;
        }
        out=src;
        return exist;
    }
    public Mat outImage()
    {
        if(out==null) throw new NullPointerException("No Detect");
        return out;
    }
    public int faceCount()
    {
        return num;
    }

    public boolean isExist() {
        return exist;
    }
}

