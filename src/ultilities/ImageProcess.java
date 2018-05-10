/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultilities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author dtvta
 */
public class ImageProcess {
    private BufferedImage buff;

    public ImageProcess(BufferedImage buff) {
        this.buff = buff;
    }
    
    public BufferedImage resizeImage(BufferedImage buff, int w, int h){
        int type = buff.getType() == 0? BufferedImage.TYPE_INT_ARGB : buff.getType();
        BufferedImage buffOut=new BufferedImage(w, h, type);
        
        Graphics2D g2D= buffOut.createGraphics();
        g2D.drawImage(buff, 0, 0, w, h, null);
        g2D.dispose();
        
        return buffOut;
    }
}
