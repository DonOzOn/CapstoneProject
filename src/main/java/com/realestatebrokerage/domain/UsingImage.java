package com.realestatebrokerage.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "using_image")
public class UsingImage extends AbstractAuditingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(referencedColumnName =  "id", name = "image_id")
    private Image image;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "type_id")
    private UsingType usingType;

    @OneToOne
    @JoinColumn(referencedColumnName = "id", name = "product_post_id")
    private ProductPost productPost;

    public UsingImage() {
    }

    public UsingImage(UsingImage usingImage){
        this.id = usingImage.getId();
        if (usingImage.getImage() != null) {
            this.image = usingImage.getImage();
        }
        if (usingImage.getUsingType() != null) {
            this.usingType = usingImage.getUsingType();
        }
        if (usingImage.getProductPost() != null) {
            this.productPost = usingImage.getProductPost();
        }
    }

    public ProductPost getProductPost() {
        return productPost;
    }

    public void setProductPost(ProductPost productPost) {
        this.productPost = productPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public UsingType getUsingType() {
        return usingType;
    }

    public void setUsingType(UsingType usingType) {
        this.usingType = usingType;
    }
}
