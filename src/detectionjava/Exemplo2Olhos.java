/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectionjava;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author Elias
 */
public class Exemplo2Olhos {
    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat imagemColorida = imread("src\\pessoas\\pessoas4.jpg");
        Mat imagemCinza = new Mat();
        Imgproc.cvtColor(imagemColorida, imagemCinza, COLOR_BGR2GRAY);
        CascadeClassifier classificadorFace
                = new CascadeClassifier("src\\cascades\\haarcascade_frontalface_default.xml");
      /** É nessa váriavel que fica amarzenado as faces */
        MatOfRect  facesDetectadas = new MatOfRect();
        classificadorFace.detectMultiScale(imagemCinza, facesDetectadas);
        System.out.println(facesDetectadas.toArray().length);
        for (Rect rect: facesDetectadas.toArray()) {
            System.out.println(rect.x + "" + rect.y + "" +rect.width+"" + rect.height);
           Imgproc.rectangle(imagemColorida, new Point(rect.x, rect.y),
                new Point(rect.x+rect.width, rect.y + rect.height), 
                new Scalar(0, 0, 255), 1);
           
        }
        
        MatOfRect olhosDetectados = new MatOfRect();
        CascadeClassifier classificadorOlho = 
                new CascadeClassifier("src\\cascades\\haarcascade_eye.xml");
        classificadorOlho.detectMultiScale(imagemCinza, olhosDetectados);
        // params não ajudaram na detecção dos olhos, portanto segue os valores padrão       
        // 1.01, 5, 0, new Size(5, 5), new Size(20, 20));//
        for(Rect rect: olhosDetectados.toArray()) {
            Imgproc.rectangle(imagemColorida, new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0,0,255),2);
                    
        }
        Utilitarios ut = new Utilitarios();
        ut.mostraImagem(ut.convertMatToImage(imagemColorida));
    }
}
