package com.realestatebrokerage.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "image")
public class Image extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column( name = "url_img1")
    private String img1;

    @Lob
    @Column( name = "url_img2")
    private String img2;

    @Lob
    @Column( name = "url_img3")
    private String img3;

    @Lob
    @Column(name = "url_img4")
    private String img4;

    @Lob
    @Column( name = "url_img5")
    private String img5;

    @Lob
    @Column( name = "url_img6")
    private String img6;

    @Lob
    @Column( name = "url_img7")
    private String img7;

    @Lob
    @Column( name = "url_img8")
    private String img8;

    @Lob
    @Column( name = "url_img9")
    private String img9;

    @Lob
    @Column( name = "url_img10")
    private String img10;


    public Image() {
    }

    public Image(String img1, String img2, String img3, String img4, String img5, String img6, String img7, String img8, String img9, String img10) {
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.img5 = img5;
        this.img6 = img6;
        this.img7 = img7;
        this.img8 = img8;
        this.img9 = img9;
        this.img10 = img10;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5;
    }

    public String getImg6() {
        return img6;
    }

    public void setImg6(String img6) {
        this.img6 = img6;
    }

    public String getImg7() {
        return img7;
    }

    public void setImg7(String img7) {
        this.img7 = img7;
    }

    public String getImg8() {
        return img8;
    }

    public void setImg8(String img8) {
        this.img8 = img8;
    }

    public String getImg9() {
        return img9;
    }

    public void setImg9(String img9) {
        this.img9 = img9;
    }

    public String getImg10() {
        return img10;
    }

    public void setImg10(String img10) {
        this.img10 = img10;
    }
}
