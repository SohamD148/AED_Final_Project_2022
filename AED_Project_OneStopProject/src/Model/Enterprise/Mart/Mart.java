/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Enterprise.Mart;

import Model.Enterprise.Commodity;
import Model.Enterprise.Outlet;
import Model.Organization.MartSupervisorOrganization;
import Model.WorkQueue.OrderRequest;
import Model.WorkQueue.WorkRequest;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author sohamdeshpande
 */
public class Mart extends Outlet {
    
    private int photoId;
    private MartType type;
    private String shop_id;
    private static int shopid_counter = 0;
    private String photoPath;

    @Override
    public OutletType getOut_type() {
        return OutletType.Mart;
    }

    @Override
    public String getCategoryString() {
        if(this.type != null) {
            return this.type.name();
        }
        return "";
    }

    public enum MartType {

        Pharmacy, ConvineceStore, GroceryStore
    }

    public Mart(String name, String address, String phone) {
        super(name, address, phone);
        this.photoId = shopid_counter;
        this.shop_id = "Store" + shopid_counter;
        shopid_counter++;
        this.setOut_type(Outlet.OutletType.Mart);

        String path = "Images/StoreCut/default.png";
        String fileName = "default.png";

        File f = new File("Images/StoreCut");
        if (f.isDirectory()) {
            File[] F1 = f.listFiles();
            for (File f2 : F1) {
                if (f2.getName().equalsIgnoreCase(this.photoId + ".png")) {
                    fileName = this.photoId + ".png";
                    path = "Images/StoreCut/" + fileName;
                }
            }
        }
        this.photoPath = path;
    }

    @Override
    public void createOrganizations() {
        this.getOrganizationDirectory().getOrganizationDirectory().add(new MartSupervisorOrganization());
    }

    public int getPhotoId() {
        return this.photoId;
    }

    public MartType getType() {
        return this.type;
    }

    public void setType(MartType cat) {
        this.type = cat;
    }

    public ArrayList<Product> getGoods() {
        ArrayList<Product> result = new ArrayList<>();
        for (Commodity item : this.getCommodity()) {
            Product product = (Product) item;
            result.add(product);
        }
        return result;
    }

    public void addProductToList(Product pro) {
        this.getCommodity().add(pro);
    }
    
    @Override
    public void setShipcom_id(String id) {
        this.shop_id = id;
    }

    @Override
    public double getRate() {
        double totalRate = 0;
        double num = 0;
        for (WorkRequest wr : this.getWorkQueue().getWorkRequestDirectory()) {
            OrderRequest order = (OrderRequest) wr;
            if (order.isReviewed()) {
                totalRate = totalRate + order.getReview().getRating();
                num++;
            }
        }
        if (num == 0) {
            return -1;
        }
        BigDecimal bd = new BigDecimal(totalRate/num);
        return bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public String getPath() {
        return this.photoPath;
    }

    public void setPath(String path) {
        String newPath = "";
        try {
            BufferedImage image = ImageIO.read(new File(path));

            int radio = 0;
            if (image.getWidth() / 250 < image.getHeight() / 180) {
                radio = image.getWidth() / 250;
            } else {
                radio = image.getHeight() / 180;
            }
            int x = 0, y = 0, cutW = 250 * radio, cutH = 180 * radio;

            Rectangle rect = new Rectangle(x, y, cutW, cutH);
            BufferedImage areaImage = image.getSubimage(rect.x, rect.y, rect.width, rect.height);

            BufferedImage buffImg = new BufferedImage(cutW, cutH, BufferedImage.TYPE_INT_RGB);
            buffImg.getGraphics().drawImage(areaImage.getScaledInstance(cutW, cutH, java.awt.Image.SCALE_SMOOTH), 0, 0, null);

            String fileName = this.photoId + ".png";
            newPath = "Images/StoreCut/" + fileName;
            ImageIO.write(buffImg, "png", new File(newPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.photoPath = newPath;
    }

    @Override
    public String getShipcom_id() {
        return this.shop_id;
    }
}
