package com.realestatebrokerage.service;

import com.google.gson.Gson;
import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import com.realestatebrokerage.service.ProvinceService;
import com.realestatebrokerage.service.dto.GuestCareProductRequestDTO;
import com.realestatebrokerage.service.dto.ImageDTO;
import com.realestatebrokerage.service.dto.NewsDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.awt.font.ImageGraphicAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class Testunittest {
    @Mock
    private ProvinceRepository provinceRepository;
    @Mock
    private DistrictRepository districtRepository;
    @Mock
    private WardRepository wardRepository;
    @Mock
    private DirectionHouseRepository directionHouseRepository;
    @Mock
    private DirectionRepository directionRepository;
    @Mock
    private GuestCareProductRepository guestCareProductRepository;
    @Mock
    private ImageRepository imageRepository;
    @Mock
    private LegalStatusRepository legalStatusRepository;
    @Mock
    private LikedPostRepository likedPostRepository;
    @Mock
    private LikedReviewRepository likedReviewRepository;
    @Mock
    private ProductPostRepository productPostRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private NewRepository newRepository;



    @InjectMocks
    private ProvinceService provinceService = new ProvinceService();

    @InjectMocks
    private DistrictService districtService = new DistrictService();

    @InjectMocks
    private WardService wardService = new WardService();

    @InjectMocks
    private DirectionHouseService directionHouseService = new DirectionHouseService();

    @InjectMocks
    private DirectionService directionService = new DirectionService();

    @InjectMocks
    private GuestCareProductService guestCareProductService = new GuestCareProductService();

    @InjectMocks
    private ImageService imageService =  new ImageService();

    @InjectMocks
    private LegalStatusService legalStatusService =  new LegalStatusService();

    @InjectMocks
    private LikedService likedService =  new LikedService();

    @InjectMocks
    private NewService newService = new NewService();


    /**
     * Address service test
     * */
    @Test
    public void findAllProvinceTest(){
        Gson gs = new Gson();
        List<Province> lst = new ArrayList<>();
        lst.add(new Province("1", "hà nội","1"));
        lst.add(new Province("2", "Đà nẵng","2"));
        lst.add(new Province("3", "HCM","1"));
        when(provinceRepository.findAll()).thenReturn(lst);
        List<Province> lstExpect = lst;
        List<Province> lstActual = provinceService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllDistrictTest(){
        Gson gs = new Gson();
        List<District> districtList = new ArrayList<>();
        districtRepository.save(new District("1", "Thanh Xuân",new Province("2", "hà nội","1"),"2"));
        districtRepository.save(new District("2", "Liên Chiểu",new Province("2", "Đà nẵng","2"),"1"));
        districtRepository.save(new District("3", "Tân Bình",new Province("2", "Đà nẵng","2"),"2"));
        when(districtRepository.findAllByProvinceCode("2")).thenReturn(districtList);
        List<District> lstExpect = districtList;
        List<District> lstActual = districtService.findAllByProvinceCode("2");
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllWardTest(){
        Gson gs = new Gson();
        List<Ward> wardList = new ArrayList<>();
        wardRepository.save(new Ward("1", "Thanh Xuân","1",new District("1", "Thanh Xuân",new Province("1", "hà nội","1"),"2")));
        wardRepository.save(new Ward("2", "Liên Chiểu","2",new District("1", "Liên Chiểu",new Province("2", "Đà nẵng","2"),"1")));
        wardRepository.save(new Ward("3", "Tân Bình","2",new District("1", "Tân Bình",new Province("2", "Đà nẵng","2"),"2")));
        when(wardRepository.findAllByDistrictCode("1")).thenReturn(wardList);
        List<Ward> lstExpect = wardList;
        List<Ward> lstActual = wardService.findAllByDistrictCode("1");
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * Direction house service test
     * */
    @Test
    public void findByNameParTest(){
        Gson gs = new Gson();

        DirectionHouse directionHouse1 = new DirectionHouse();
        directionHouse1.setDiennien("Hoa");
        directionHouse1.setHoahai("La");
        directionHouse1.setId(1L);
        directionHouse1.setLucsat("Canh");
        directionHouse1.setName_par("Re");
        directionHouse1.setNguquy("Ngon");
        directionHouse1.setPhucvi("Nhanh");
        directionHouse1.setThieny("Choi");
        directionHouse1.setTuyetmenh("Bong");
        directionHouseRepository.save(directionHouse1);

        DirectionHouse directionHouse2 = new DirectionHouse();
        directionHouse1.setDiennien("Hoa2");
        directionHouse1.setHoahai("La2");
        directionHouse1.setId(2L);
        directionHouse1.setLucsat("Canh2");
        directionHouse1.setName_par("Re2");
        directionHouse1.setNguquy("Ngon2");
        directionHouse1.setPhucvi("Nhanh2");
        directionHouse1.setThieny("Choi2");
        directionHouse1.setTuyetmenh("Bong2");
        directionHouseRepository.save(directionHouse2);

        Optional<DirectionHouse> directionHouseOptional = null ;

        when(directionHouseRepository.findByParName("Re2")).thenReturn(directionHouseOptional);
        Optional<DirectionHouse> lstExpect = directionHouseOptional;
        Optional<DirectionHouse> lstActual = directionHouseService.findByNamePar("Re2");
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * Direction Service test
     * */
    @Test
    public void findAllDirectionTest(){
        Gson gs = new Gson();
        List<Direction> directionList = new ArrayList<>();
        directionRepository.save(new Direction("Đông"));
        directionRepository.save(new Direction("Nam"));
        directionRepository.save(new Direction("Bắc"));
        when(directionRepository.findAll()).thenReturn(directionList);
        List<Direction> lstExpect = directionList;
        List<Direction> lstActual = directionService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * Guest care service test
     * */
    @Test
    public void findAllGuestCareTest(){
        Gson gs = new Gson();
        List<GuestCareProduct> guestCareProductList = new ArrayList<>();
        guestCareProductRepository.save(new GuestCareProduct("111","abc123.com","don","Co lien he 2",null,null, true));
        guestCareProductRepository.save(new GuestCareProduct("222","abc12.com","ha","Co lien he 3",null,null, true));
        guestCareProductRepository.save(new GuestCareProduct("333","abc1.com","manh","Co lien he 4",null,null, true));
        when(guestCareProductRepository.findAllByStatusIsTrue()).thenReturn(guestCareProductList);
        List<GuestCareProduct> lstExpect = guestCareProductList;
        List<GuestCareProduct> lstActual = guestCareProductService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllGuestCareByIdTest(){
        Gson gs = new Gson();
        Optional<GuestCareProduct> guestCareProduct = Optional.of(new GuestCareProduct("222", "abc123.com", "don", "Co lien he 2", null, null, true));
        guestCareProductRepository.save(new GuestCareProduct("111","abc123.com","don","Co lien he 2",null,null, true));
        guestCareProductRepository.save(new GuestCareProduct("222","abc12.com","ha","Co lien he 3",null,null, true));
        guestCareProductRepository.save(new GuestCareProduct("333","abc1.com","manh","Co lien he 4",null,null, true));
        when(guestCareProductRepository.findById(2L)).thenReturn(guestCareProduct);
        Optional<GuestCareProduct> lstExpect = guestCareProduct;
        Optional<GuestCareProduct> lstActual = guestCareProductService.findById(2L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void createGuestCareProductTest(){
        Gson gson = new Gson();
        GuestCareProductRequestDTO guestCareProductRequestDTO = new GuestCareProductRequestDTO();
        guestCareProductRequestDTO.setId(1L);
        guestCareProductRequestDTO.setEmail("abc123");
        guestCareProductRequestDTO.setName("don");
        guestCareProductRequestDTO.setPhone("1234");
        guestCareProductRequestDTO.setMess("see");
        guestCareProductRequestDTO.setStatus(true);

        GuestCareProduct guestCareProduct = new GuestCareProduct();
        guestCareProduct.setId(1L);
        guestCareProduct.setEmail("abc123");
        guestCareProduct.setName("don");
        guestCareProduct.setPhone("1234");
        guestCareProduct.setMess("see");
        guestCareProduct.setStatus(true);

        when(guestCareProductRepository.save(Mockito.any(GuestCareProduct.class))).thenReturn(guestCareProduct);

        GuestCareProduct expect = new GuestCareProduct();
        expect = guestCareProduct;
        System.out.println("request : " + guestCareProductRequestDTO);
        GuestCareProduct actual = guestCareProductService.createGuestCareProduct(guestCareProductRequestDTO);


        System.out.println("actual : " + actual);
        assertThat(actual.getId()).isSameAs(expect.getId());
        assertThat(actual.getName()).isSameAs(expect.getName());
        assertThat(actual.getMess()).isSameAs(expect.getMess());
        assertThat(actual.getEmail()).isSameAs(expect.getEmail());
        assertThat(actual.getProductPost()).isSameAs(expect.getProductPost());
        assertThat(actual.getUser()).isSameAs(expect.getUser());
        assertThat(actual.isStatus()).isSameAs(expect.isStatus());

        GuestCareProduct expectNull = new GuestCareProduct();
        expectNull = null;
        GuestCareProductRequestDTO guestCareProductRequestDTO1 = null;
        GuestCareProduct actualNull = guestCareProductService.createGuestCareProduct(guestCareProductRequestDTO1);
        assertEquals(expectNull, actualNull);
    }

    @Test
    public void updateGuestCareProductTest(){

        GuestCareProductRequestDTO guestCareProductRequestDTO = new GuestCareProductRequestDTO();
        guestCareProductRequestDTO.setId(1L);
        guestCareProductRequestDTO.setEmail("abc123");
        guestCareProductRequestDTO.setName("don123");
        guestCareProductRequestDTO.setPhone("1234");
        guestCareProductRequestDTO.setMess("see");
        guestCareProductRequestDTO.setStatus(true);


        GuestCareProduct guestCareProduct = new GuestCareProduct();
        guestCareProduct.setId(1L);
        guestCareProduct.setEmail("abc123");
        guestCareProduct.setName("don");
        guestCareProduct.setPhone("1234");
        guestCareProduct.setMess("see");
        guestCareProduct.setStatus(true);
        Optional<GuestCareProduct> oprotion =  Optional.of(guestCareProduct);
        when(guestCareProductRepository.findById(guestCareProductRequestDTO.getId())).thenReturn(oprotion);
        when(guestCareProductRepository.save(Mockito.any(GuestCareProduct.class))).thenReturn(guestCareProduct);

        GuestCareProductRequestDTO expect = new GuestCareProductRequestDTO();
        expect = guestCareProductRequestDTO;
        GuestCareProduct actual = guestCareProductService.updateGuestCare(guestCareProductRequestDTO).orElse(null);
        assertThat(actual.getName()).isSameAs(expect.getName());

        GuestCareProduct expectNull = new GuestCareProduct();
        expectNull = null;
        GuestCareProductRequestDTO guestCareProductRequestDTO1 = null;
        GuestCareProduct actualNull = guestCareProductService.createGuestCareProduct(guestCareProductRequestDTO1);
        assertEquals(expectNull, actualNull);
    }

    @Test
    public void deleteGuestCareProductTest(){

        GuestCareProduct guestCareProduct = new GuestCareProduct();
        guestCareProduct.setId(1L);
        guestCareProduct.setEmail("abc123");
        guestCareProduct.setName("don");
        guestCareProduct.setPhone("1234");
        guestCareProduct.setMess("see");
        guestCareProduct.setStatus(true);
        Optional<GuestCareProduct> oprotion =  Optional.of(guestCareProduct);
        when(guestCareProductRepository.findById(1L)).thenReturn(oprotion);
        when(guestCareProductRepository.save(Mockito.any(GuestCareProduct.class))).thenReturn(guestCareProduct);

        GuestCareProduct actual = guestCareProductService.deleteGuest(1L).orElse(null);
        assertEquals(false, actual.isStatus());

        GuestCareProduct expectNull = new GuestCareProduct();
        expectNull = null;
        GuestCareProduct actualNull = guestCareProductService.deleteGuest(null).orElse(null);
        assertEquals(expectNull, actualNull);
    }

    /**
     * Hibernate search service test
     * */


    /**
     * Image search service test
     * */
    @Test
    public void findAllImageTest(){
        Gson gs = new Gson();
        List<Image> lst = new ArrayList<>();
        lst.add(new Image("image1", "image2","image3","image4","image5","image6","image7","image8","image9","image10"));
        lst.add(new Image("image11", "image12","image13","image14","image15","image16","image17","image18","image19","image20"));
        lst.add(new Image("image21", "image22","image23","image24","image25","image26","image27","image28","image29","image30"));
        when(imageRepository.findAll()).thenReturn(lst);
        List<Image> lstExpect = lst;
        List<Image> lstActual = imageService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }
    @Test
    public void findImageByIdTest(){
        Gson gs = new Gson();
        Optional<Image> image = Optional.of(new Image("image1", "image2","image3","image4","image5","image6","image7","image8","image9","image10"));
        imageRepository.save(new Image("image1", "image2","image3","image4","image5","image6","image7","image8","image9","image10"));
        imageRepository.save(new Image("image11", "image12","image13","image14","image15","image16","image17","image18","image19","image20"));
        imageRepository.save(new Image("image21", "image22","image23","image24","image25","image26","image27","image28","image29","image30"));
        when(imageRepository.findById(1L)).thenReturn(image);
        Optional<Image> lstExpect = image;
        Optional<Image> lstActual = imageService.findById(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void createImageTest(){
        Gson gs = new Gson();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setId(1L);
        imageDTO.setImg1("img1");
        imageDTO.setImg2("img2");
        imageDTO.setImg3("img3");
        imageDTO.setImg4("img4");
        imageDTO.setImg5("img5");
        imageDTO.setImg6("img6");
        imageDTO.setImg7("img7");
        imageDTO.setImg8("img8");
        imageDTO.setImg9("img9");
        imageDTO.setImg10("img10");

        Image image = new Image();
        image.setId(1L);
        image.setImg1("img1");
        image.setImg2("img2");
        image.setImg3("img3");
        image.setImg4("img4");
        image.setImg5("img5");
        image.setImg6("img6");
        image.setImg7("img7");
        image.setImg8("img8");
        image.setImg9("img9");
        image.setImg10("img10");

        when(imageRepository.save(Mockito.any(Image.class))).thenReturn(image);

        Image expect = new Image();
        expect = image;
        Image actual = imageService.createProduct(imageDTO);

        String gsExpect = gs.toJson(expect);
        String gsActual = gs.toJson(actual);
        assertEquals(gsExpect, gsActual);

        ImageDTO imageDTONull = null;
        Image actualNull = imageService.createProduct(imageDTONull);
        assertEquals(null, actualNull);
    }

    @Test
    public void updateImageTest(){
        Gson gs = new Gson();
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setId(1L);
        imageDTO.setImg1("img1");
        imageDTO.setImg2("img2");
        imageDTO.setImg3("img3");
        imageDTO.setImg4("img4");
        imageDTO.setImg5("img5");
        imageDTO.setImg6("img11");
        imageDTO.setImg7("img7");
        imageDTO.setImg8("img8");
        imageDTO.setImg9("img9");
        imageDTO.setImg10("img10");

        Image image = new Image();
        image.setId(1L);
        image.setImg1("img1");
        image.setImg2("img2");
        image.setImg3("img3");
        image.setImg4("img4");
        image.setImg5("img5");
        image.setImg6("img6");
        image.setImg7("img7");
        image.setImg8("img8");
        image.setImg9("img9");
        image.setImg10("img10");
        Optional<Image> oprotion =  Optional.of(image);
        when(imageRepository.findById(imageDTO.getId())).thenReturn(oprotion);
        when(imageRepository.save(Mockito.any(Image.class))).thenReturn(image);

        ImageDTO expect = new ImageDTO();
        expect = imageDTO;
        Image actual = imageService.updateImage(imageDTO).orElse(null);
        assertThat(actual.getImg6()).isSameAs(expect.getImg6());

        when(imageRepository.findById(null)).thenReturn(null);
        Optional<Image> actualNull = imageService.updateImage(null);
        assertEquals(null, actualNull);
    }

    /**
     * Legal status Service Test
     * */
    @Test
    public void findAllLegalStatusTest(){
        Gson gs = new Gson();
        List<LegalStatus> legalStatusList = new ArrayList<>();
        legalStatusRepository.save(new LegalStatus("Sổ Đỏ"));
        legalStatusRepository.save(new LegalStatus("Sổ Hồng"));
        legalStatusRepository.save(new LegalStatus("Sổ Trắng"));
        when(legalStatusRepository.findAll()).thenReturn(legalStatusList);
        List<LegalStatus> lstExpect = legalStatusList;
        List<LegalStatus> lstActual = legalStatusService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * Liked service Test
     * */
    @Test
    public void checkLikedPostTest(){
        Gson gs = new Gson();
        int count = 0;
        //case 1
        LikedPost likedPost = new LikedPost();
        ProductPost productPost = new ProductPost(null,"abc",null,"222",null,12,11,11,null,null,null,"ha noi","Khong co gi","Nhieu lam",null,true);
        User user = new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null);

        when(productPostRepository.save(Mockito.any(ProductPost.class))).thenReturn(productPost);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        Optional<ProductPost> oprotion =  Optional.of(productPost);
        when(productPostRepository.findById(1L)).thenReturn(oprotion);
        Optional<User> oprotionUser =  Optional.of(user);
        when(userRepository.findById(1L)).thenReturn(oprotionUser);
        when(likedPostRepository.countAllByUserIdAndProductPostId(1L, 1L)).thenReturn(count);
        System.out.println("count: " + count);
        when(likedPostRepository.save(Mockito.any(LikedPost.class))).thenReturn(likedPost);

        LikedPost expect = new LikedPost();
        expect = likedPost;

        LikedPost actual = likedService.checkLikePost(1L, 1L);
        String expectgs = gs.toJson(expect);
        String actualgs = gs.toJson(actual);
        assertEquals(expectgs, actualgs);
    }

    @Test
    public void checkLikedPostTestCase2(){
        //case 2
        Gson gs = new Gson();
        ProductPost productPost = new ProductPost(null,"abc",null,"222",null,12,11,11,null,null,null,"ha noi","Khong co gi","Nhieu lam",null,true);
        User user = new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null);

        when(productPostRepository.save(Mockito.any(ProductPost.class))).thenReturn(productPost);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        Optional<ProductPost> oprotion =  Optional.of(productPost);
        when(productPostRepository.findById(1L)).thenReturn(oprotion);
        Optional<User> oprotionUser =  Optional.of(user);
        when(userRepository.findById(1L)).thenReturn(oprotionUser);

        LikedPost likedPostCase2 = new LikedPost(
            new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null),
            new ProductPost(null,"abc",null,"222",null,12,11,11,null,null,null,"ha noi","Khong co gi","Nhieu lam",null,true), true);

        when(likedPostRepository.save(Mockito.any(LikedPost.class))).thenReturn(likedPostCase2);
        LikedPost expectCase2 = new LikedPost();
        expectCase2 = likedPostCase2;

        LikedPost actualCase2 = likedService.checkLikePost(1L, 1L);
        String expectgsCase2 = gs.toJson(expectCase2);
        String actualgsCase2 = gs.toJson(actualCase2);
        assertEquals(expectgsCase2, actualgsCase2);
    }

    @Test
    public void checkLikedReviewTest(){
        Gson gs = new Gson();
        int count = 0;
        //case 1
        LikedReview likedReview = new LikedReview();
        Review review = new Review(null,"abc",null,11,12,null,null,null,"abc","bcd",true,"anhDep",true);
        User user = new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null);

        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        Optional<Review> oprotion =  Optional.of(review);
        when(reviewRepository.findById(1L)).thenReturn(oprotion);
        Optional<User> oprotionUser =  Optional.of(user);
        when(userRepository.findById(1L)).thenReturn(oprotionUser);
        when(likedReviewRepository.countAllByUserIdAndReviewId(1L, 1L)).thenReturn(count);
        when(likedReviewRepository.save(Mockito.any(LikedReview.class))).thenReturn(likedReview);

        LikedReview expect = new LikedReview();
        expect = likedReview;

        LikedReview actual = likedService.checkLikeReview(1L, 1L);
        String expectgs = gs.toJson(expect);
        String actualgs = gs.toJson(actual);
        assertEquals(expectgs, actualgs);
    }

    @Test
    public void checkLikedReviewTestCase2(){
        //case 2
        Gson gs = new Gson();
        Review review = new Review(null,"abc",null,11,12,null,null,null,"abc","bcd",true,"anhDep",true);
        User user = new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null);

        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        Optional<Review> oprotion =  Optional.of(review);
        when(reviewRepository.findById(1L)).thenReturn(oprotion);
        Optional<User> oprotionUser =  Optional.of(user);
        when(userRepository.findById(1L)).thenReturn(oprotionUser);

        LikedReview likedReviewCase = new LikedReview(
            new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null),
            new Review(null,"abc",null,11,12,null,null,null,"abc","bcd",true,"anhDep",true),true);

        when(likedReviewRepository.save(Mockito.any(LikedReview.class))).thenReturn(likedReviewCase);
        LikedReview expectCase2 = new LikedReview();
        expectCase2 = likedReviewCase;

        LikedReview actualCase2 = likedService.checkLikeReview(1L, 1L);
        String expectgsCase2 = gs.toJson(expectCase2);
        String actualgsCase2 = gs.toJson(actualCase2);
        assertEquals(expectgsCase2, actualgsCase2);
    }

    @Test
    public void checkCountLikePost(){
        //case 2
        Gson gs = new Gson();
        int count = 1;
        ProductPost productPost = new ProductPost(null,"abc",null,"222",null,12,11,11,null,null,null,"ha noi","Khong co gi","Nhieu lam",null,true);
        User user = new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null);

        when(productPostRepository.save(Mockito.any(ProductPost.class))).thenReturn(productPost);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user);


        LikedPost likedPostCase = new LikedPost(
            new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null),
            new ProductPost(null,"abc",null,"222",null,12,11,11,null,null,null,"ha noi","Khong co gi","Nhieu lam",null,true), true);
        when(likedPostRepository.save(Mockito.any(LikedPost.class))).thenReturn(likedPostCase);
        when(likedPostRepository.countAllByUserIdAndProductPostId(1L, 1L)).thenReturn(count);

        int expectCase2 = 1;
        int actualCase2 = likedService.countLikePost(1L);

        String expectgsCase2 = gs.toJson(expectCase2);
        String actualgsCase2 = gs.toJson(actualCase2);
//        assertEquals(expectgsCase2, actualgsCase2);
    }


    /**
     * New service test
     * */


    @Test
    void createNews() {
        Gson gson = new Gson();
        NewsDTO newDTO = new NewsDTO();
        newDTO.setContent("1");
        newDTO.setId(2L);
        newDTO.setStatus(true);

        News news = new News();
        news.setContent("1");
        news.setId(2L);
        news.setStatus(true);

        when(newRepository.save(Mockito.any(News.class))).thenReturn(news);

        News expect = new News();
        expect = news;

        News actual = new News();
        actual = newService.createNews(newDTO);

        String gsExect = gson.toJson(expect);
        String gsActual = gson.toJson(actual);

        assertEquals(gsExect, gsActual);

    }

    @Test
    public void findAllNews(){
        Gson gs = new Gson();
        List<News> lst = new ArrayList<>();
        lst.add(new News("abc", "decription1","image1","content1",true));
        lst.add(new News("title2", "decription2","image2","content2",true));
        lst.add(new News("title3", "decription1","image1","content1",true));
        when(newRepository.findAll()).thenReturn(lst);
        List<News> lstExpect = lst;
        List<News> lstActual = newService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllNewsbyIdTest(){
        Gson gs = new Gson();
        List<News> lst = new ArrayList<>();
        Optional<News> news = Optional.of(new News("abc", "decription1","image1","content1",true));
        lst.add(new News("abc", "decription1","image1","content1",true));
        lst.add(new News("title2", "decription2","image2","content2",true));
        lst.add(new News("title3", "decription1","image1","content1",true));
        when(newRepository.findById(1L)).thenReturn(news);
        Optional<News> lstExpect = news;
        Optional<News> lstActual = newService.findById(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void updateNewsTest(){
        Gson gs = new Gson();
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(1L);
        newsDTO.setContent("content");
        newsDTO.setDecription("decription222");
        newsDTO.setImageUrl("imageUrl");
        newsDTO.setTitle("title");
        newsDTO.setStatus(true);


        News news = new News();
        news.setId(1L);
        news.setContent("content");
        news.setDecription("decription222");
        news.setImageUrl("imageUrl");
        news.setTitle("title");
        news.setStatus(true);
        Optional<News> oprotion =  Optional.of(news);
        when(newRepository.findById(newsDTO.getId())).thenReturn(oprotion);
        when(newRepository.save(Mockito.any(News.class))).thenReturn(news);

        NewsDTO expect = new NewsDTO();
        expect = newsDTO;
        News actual = newService.updateNews(newsDTO).orElse(null);

        String gsExect = gs.toJson(expect.getDecription());
        String gsActual = gs.toJson(actual.getDecription());

        assertEquals(gsExect, gsActual);
    }

    @Test
    public void deleteNewsTest(){
        News news = new News();
        news.setId(1L);
        news.setContent("content");
        news.setDecription("decription222");
        news.setImageUrl("imageUrl");
        news.setTitle("title");
        news.setStatus(true);
        Optional<News> oprotion =  Optional.of(news);
        when(newRepository.findById(1L)).thenReturn(oprotion);
        when(newRepository.save(Mockito.any(News.class))).thenReturn(news);

        newService.deleteNews(1L);
        assertEquals(false, news.getStatus());

        GuestCareProduct expectNull = new GuestCareProduct();
        expectNull = null;
        GuestCareProduct actualNull = guestCareProductService.deleteGuest(null).orElse(null);
        assertEquals(expectNull, actualNull);
    }

}
