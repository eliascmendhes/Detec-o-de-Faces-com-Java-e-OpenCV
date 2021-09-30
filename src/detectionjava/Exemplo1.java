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
public class Exemplo1 {

    public static void main(String args[]) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat imagemColorida = imread("src\\outros\\carro3.jpg");
        Mat imagemCinza = new Mat();
        Imgproc.cvtColor(imagemColorida, imagemCinza, COLOR_BGR2GRAY);
        CascadeClassifier classificador
                = new CascadeClassifier("src\\cascades\\cars.xml");
      /** É nessa váriavel que fica armazenado as faces */
        MatOfRect  facesDetectadas = new MatOfRect();
        classificador.detectMultiScale(imagemCinza, facesDetectadas,
        1.01, // scale factor // Quando faces estão perto da camera . elas serão maiores que dos faces ao fundo da  imamgeem 
        8, // minNeighbors
        0, // flags
        new Size(30,30), // minSize // tamanho min de uma face
        new Size(500,500)  // maxSize // tamanho máximo de uma face 
        );
        System.out.println(facesDetectadas.toArray().length);
        for (Rect rect: facesDetectadas.toArray()) {
            System.out.println(rect.x + "" + rect.y + "" +rect.width+"" + rect.height);
           Imgproc.rectangle(imagemColorida, new Point(rect.x, rect.y),
                new Point(rect.x+rect.width, rect.y + rect.height), 
                new Scalar(0, 0, 255), 1);
           
        }
        Utilitarios ut = new Utilitarios();
        ut.mostraImagem(ut.convertMatToImage(imagemColorida));
    }
}
