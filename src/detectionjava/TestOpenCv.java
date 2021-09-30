/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detectionjava;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_COLOR;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import org.opencv.imgproc.Imgproc;
import static org.opencv.imgproc.Imgproc.COLOR_BGR2GRAY;

/**
 *
 * @author Elias
 */
public class TestOpenCv {
    public static void main(String args[]){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // códiog que vai permitir acesso ao opencv
        System.out.println(Core.VERSION);
        // matriz que converte imagem para uma matriz numerica
        Mat imgColorida = imread("src\\detectionjava\\opencv.jpeg", CV_LOAD_IMAGE_COLOR);
        Utilitarios ut = new Utilitarios();
        ut.mostraImagem(ut.convertMatToImage(imgColorida));
        
        // uma nova img é declarada pelo MAT
        
        Mat imagemCinza = new Mat();
        Imgproc.cvtColor(imgColorida, imagemCinza, COLOR_BGR2GRAY);
        ut.mostraImagem(ut.convertMatToImage(imagemCinza));
            
    }
    
}
