package com.realestatebrokerage.service;

import com.google.gson.Gson;
import com.realestatebrokerage.domain.*;
import com.realestatebrokerage.repository.*;
import com.realestatebrokerage.service.ProvinceService;
import com.realestatebrokerage.service.dto.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    @Mock
    private NotificationRepository notificationRepository;
    @Mock
    private ParManRepository parManRepository;
    @Mock
    private ParWomanRepository parWomanRepository;
    @Mock
    private ProductPostTypeRepository postTypeRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private UtilitiesRepository utilitiesRepository;
    @Mock
    private ProductTypeChildRepository productTypeChildRepository;
    @Mock
    private ProductTypeRepository productTypeRepository;

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

    @InjectMocks
    private NotificationService notificationService = new NotificationService();

    @InjectMocks
    private ParManService parManService = new ParManService();

    @InjectMocks
    private ParWomanService parWomanService = new ParWomanService();

    @InjectMocks
    private ProductPostService productPostService = new ProductPostService();

    @InjectMocks
    private ProductService productService = new ProductService();

    @InjectMocks
    private ProductTypeChildService productTypeChildService = new ProductTypeChildService();

    @InjectMocks
    private ProductTypeService productTypeService = new ProductTypeService();

    @InjectMocks
    private ReviewService reviewService = new ReviewService();

//    @BeforeEach
//    public void init() {
//        user = new User();
//        user.setLogin(DEFAULT_LOGIN);
//        user.setPassword(RandomStringUtils.random(60));
//        user.setActivated(true);
//        user.setEmail(DEFAULT_EMAIL);
//        user.setFirstName(DEFAULT_FIRSTNAME);
//        user.setLastName(DEFAULT_LASTNAME);
//        user.setImageUrl(DEFAULT_IMAGEURL);
//        user.setLangKey(DEFAULT_LANGKEY);
//
//        when(dateTimeProvider.getNow()).thenReturn(Optional.of(LocalDateTime.now()));
//        auditingHandler.setDateTimeProvider(dateTimeProvider);
//    }

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

    /**
     * Notification Service Test
     * */
    @Test
    public void createNotiTest(){
        Gson gson = new Gson();
        NotificationRequestDTO notificationRequestDTO = new NotificationRequestDTO();
        notificationRequestDTO.setUserSend(null);
        notificationRequestDTO.setUserReceive(null);
        notificationRequestDTO.setContent("Content");
        notificationRequestDTO.setType(1);
        notificationRequestDTO.setTitle("Title");
        notificationRequestDTO.setStatus(true);

        Notification notification = new Notification();
        notification.setUserSend(null);
        notification.setUserReceive(null);
        notification.setContent("Content");
        notification.setType(1);
        notification.setTitle("Title");
        notification.setStatus(true);
        when(notificationRepository.save(Mockito.any(Notification.class))).thenReturn(notification);

        Notification expect = new Notification();
        expect = notification;

        Notification actual = new Notification();
        actual = notificationService.createdNoti(notificationRequestDTO);

        String gsExect = gson.toJson(expect);
        String gsActual = gson.toJson(actual);

        assertEquals(gsExect, gsActual);
    }
    @Test
    public void deleteNotiTest(){
        Notification notification = new Notification();
        notification.setUserSend(null);
        notification.setUserReceive(null);
        notification.setContent("Content");
        notification.setType(1);
        notification.setTitle("Title");
        notification.setStatus(true);
        Optional<Notification> oprotion =  Optional.of(notification);
        when(notificationRepository.findById(1L)).thenReturn(oprotion);
        when(notificationRepository.save(Mockito.any(Notification.class))).thenReturn(notification);

        notificationService.deleteNoti(1L);
        assertEquals(false, notification.isStatus());
    }

    /**
     * Parman Service Test
     * */
    @Test
    public void findAllParmenByIdTest(){
        Gson gs = new Gson();
        List<ParMan> lst = new ArrayList<>();
        Optional<ParMan> parMan = Optional.of(new ParMan("decription1"));
        lst.add(new ParMan("decription1"));
        lst.add(new ParMan("decription2"));
        lst.add(new ParMan("decription3"));
        when(parManRepository.findById(1L)).thenReturn(parMan);
        Optional<ParMan> lstExpect = parMan;
        Optional<ParMan> lstActual = parManService.findByID(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * Parwoman Service Test
     * */
    @Test
    public void findAllParwomenByIdTest(){
        Gson gs = new Gson();
        List<ParWoman> lst = new ArrayList<>();
        Optional<ParWoman> parWoman = Optional.of(new ParWoman("decription1"));
        lst.add(new ParWoman("decription1"));
        lst.add(new ParWoman("decription2"));
        lst.add(new ParWoman("decription3"));
        when(parWomanRepository.findById(1L)).thenReturn(parWoman);
        Optional<ParWoman> lstExpect = parWoman;
        Optional<ParWoman> lstActual = parWomanService.findByID(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * ProductPost service test
     * */
    @Test
    public void findAllProductPostTest(){
        Gson gs = new Gson();
        List<ProductPost> lst = new ArrayList<>();

        lst.add(new ProductPost(null,"projectname1",null,"productPostTitle1",33,12,11,11,null,null,null,"ha noi","Khong co gi 1","Nhieu lam 1",null,true));
        lst.add(new ProductPost(null,"projectname2",null,"productPostTitle2",33,12,11,11,null,null,null,"da nang","Khong co gi 2","Nhieu lam 2",null,true));
        lst.add(new ProductPost(null,"projectname3",null,"productPostTitle3",33,12,11,11,null,null,null,"ho chi minh","Khong co gi 3","Nhieu lam 3",null,true));
        when(productPostRepository.findAll()).thenReturn(lst);
        List<ProductPost> lstExpect = lst;
        List<ProductPost> lstActual = productPostService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllByUserIDTest(){
        Gson gs = new Gson();
        List<ProductPost> lst = null;
        lst.add(new ProductPost(new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null),
            "projectname1",null,"productPostTitle1",33,12,11,11,null,null,null,"ha noi","Khong co gi 1","Nhieu lam 1",null,true));
        lst.add(new ProductPost(new User("don456","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null),
            "projectname2",null,"productPostTitle2",33,12,11,11,null,null,null,"da nang","Khong co gi 2","Nhieu lam 2",null,true));
        lst.add(new ProductPost(new User("don456","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null),
            "projectname3",null,"productPostTitle3",33,12,11,11,null,null,null,"ho chi minh","Khong co gi 3","Nhieu lam 3",null,true));
        when(productPostRepository.findAllByUserIdAndStatusIsTrue(1L)).thenReturn(lst);
        List<ProductPost> lstExpect = lst;
        List<ProductPost> lstActual = productPostService.findAllByUserID(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllByProducIdTest(){
        Gson gs = new Gson();
        Optional<ProductPost> productPost = Optional.of(new ProductPost(null,"projectname1",null,"productPostTitle1",33,12,11,11,null,null,null,"ha noi","Khong co gi 1","Nhieu lam 1",null,true));
        productPostRepository.save(new ProductPost(null,"projectname1",null,"productPostTitle1",33,12,11,11,null,null,null,"ha noi","Khong co gi 1","Nhieu lam 1",
            new Product(11L,12L,null,null,11,22,33,null,null,null,true),true));
        productPostRepository.save(new ProductPost(null,"projectname2",null,"productPostTitle2",33,12,11,11,null,null,null,"da nang","Khong co gi 2","Nhieu lam 2",
            new Product(22L,33L,null,null,44,55,77,null,null,null,true),true));
        productPostRepository.save(new ProductPost(null,"projectname3",null,"productPostTitle3",33,12,11,11,null,null,null,"ho chi minh","Khong co gi 3","Nhieu lam 3",
            new Product(55L,66L,null,null,88,99,66,null,null,null,true),true));
        when(productPostRepository.findAllByStatusTrueAndProductIdAndProductPostTypeId(1L,1L)).thenReturn(productPost);
        Optional<ProductPost> lstExpect = productPost;
        Optional<ProductPost> lstActual = productPostService.findAllByProduct(1L,1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllByProducPostTypeTest(){
        Gson gs = new Gson();
        List<ProductPost> lst = new ArrayList<>();
        lst.add(new ProductPost(null,"projectname1",new ProductPostType("Thue"),"productPostTitle1",33,12,11,11,null,null,null,"ha noi","Khong co gi 1","Nhieu lam 1",null,true));
        lst.add(new ProductPost(null,"projectname2",new ProductPostType("Thue"),"productPostTitle2",33,12,11,11,null,null,null,"da nang","Khong co gi 2","Nhieu lam 2",null,true));
        lst.add(new ProductPost(null,"projectname3",new ProductPostType("Thue"),"productPostTitle3",33,12,11,11,null,null,null,"ho chi minh","Khong co gi 3","Nhieu lam 3",null,true));
        when(productPostRepository.findAllByProductPostType(1L)).thenReturn(lst);
        List<ProductPost> lstExpect = lst;
        List<ProductPost> lstActual = productPostService.findAllByProductPostType(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllByProvinceTest(){
        Gson gs = new Gson();
        List<ProductPost> lst = new ArrayList<>();
        lst.add(new ProductPost(null,"projectname1",null,"productPostTitle1",33,12,11,11,null,new Province("1","Ha noi","1"),null,"ha noi","Khong co gi 1","Nhieu lam 1",null,true));
        lst.add(new ProductPost(null,"projectname2",null,"productPostTitle2",33,12,11,11,null,new Province("2","Da Nang","2"),null,"ha noi","Khong co gi 2","Nhieu lam 2",null,true));
        lst.add(new ProductPost(null,"projectname3",null,"productPostTitle3",33,12,11,11,null,new Province("3","HCM","3"),null,"ha noi","Khong co gi 3","Nhieu lam 3",null,true));
        when(productPostRepository.findAllByProvince("1")).thenReturn(lst);
        List<ProductPost> lstExpect = lst;
        List<ProductPost> lstActual = productPostService.findAllByProvince("1");
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findProductPostByIdTest(){
        Gson gs = new Gson();
        Optional<ProductPost> productPost = Optional.of(new ProductPost(null,"projectname1",null,"productPostTitle1",33,12,11,11,null,new Province("1","Ha noi","1"),null,"ha noi","Khong co gi 1","Nhieu lam 1",null,true));
        productPostRepository.save(new ProductPost(null,"projectname1",null,"productPostTitle1",33,12,11,11,null,new Province("1","Ha noi","1"),null,"ha noi","Khong co gi 1","Nhieu lam 1",null,true));
        productPostRepository.save(new ProductPost(null,"projectname2",null,"productPostTitle2",33,12,11,11,null,new Province("2","Da Nang","2"),null,"ha noi","Khong co gi 2","Nhieu lam 2",null,true));
        productPostRepository.save(new ProductPost(null,"projectname3",null,"productPostTitle3",33,12,11,11,null,new Province("3","HCM","3"),null,"ha noi","Khong co gi 3","Nhieu lam 3",null,true));
        when(productPostRepository.findById(1L)).thenReturn(productPost);
        Optional<ProductPost> lstExpect = productPost;
        Optional<ProductPost> lstActual = productPostService.findByID(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }


    @Test
    public void createProductPostTest(){
        Gson gs = new Gson();
        ProductPostRequestDTO productPostRequestDTO = new ProductPostRequestDTO();
        productPostRequestDTO.setId(1L);
        productPostRequestDTO.setProduct(null);
        productPostRequestDTO.setAddress("Dia chi");
        productPostRequestDTO.setContent("noi dung");
        productPostRequestDTO.setProductPostTitle("tieu de");
        productPostRequestDTO.setDistrict(null);
        productPostRequestDTO.setProvince(null);
        productPostRequestDTO.setWard(null);
        productPostRequestDTO.setShortDescription("mo ta ngan");
        productPostRequestDTO.setTotalLike(11);
        productPostRequestDTO.setTotalReport(11);
        productPostRequestDTO.setTotalShare(11);
        productPostRequestDTO.setTypeDeal(11);
        productPostRequestDTO.setUser(null);
        productPostRequestDTO.setStatus(true);

        ProductPost productPost = new ProductPost();
        productPost.setId(1L);
        productPost.setProduct(null);
        productPost.setAddress("Dia chi");
        productPost.setContent("noi dung");
        productPost.setProductPostTitle("tieu de");
        productPost.setDistrict(null);
        productPost.setProvince(null);
        productPost.setWard(null);
        productPost.setShortDescription("mo ta ngan");
        productPost.setTotalLike(11);
        productPost.setTotalReport(11);
        productPost.setTotalShare(11);
        productPost.setTypeDeal(11);
        productPost.setUser(null);
        productPost.setStatus(true);

        when(productPostRepository.save(Mockito.any(ProductPost.class))).thenReturn(productPost);

        ProductPost expect = new ProductPost();
        expect = productPost;

        ProductPostRequestDTO actual = new ProductPostRequestDTO();
        actual = productPostRequestDTO;

        assertEquals(expect.getContent(), actual.getContent());
        assertEquals(expect.getDistrict(), actual.getDistrict());
        assertEquals(expect.getProduct(), actual.getProduct());
        assertEquals(expect.getWard(), actual.getWard());
        assertEquals(expect.getProductPostType(), actual.getProductPostType());
    }

    @Test
    public void updateProductPostTest(){
        Gson gs = new Gson();
        ProductPostRequestDTO productPostRequestDTO = new ProductPostRequestDTO();
        productPostRequestDTO.setId(1L);
        productPostRequestDTO.setProduct(null);
        productPostRequestDTO.setAddress("Dia chi");
        productPostRequestDTO.setContent("noi dung");
        productPostRequestDTO.setProductPostTitle("tieu de");
        productPostRequestDTO.setDistrict(null);
        productPostRequestDTO.setProvince(null);
        productPostRequestDTO.setWard(null);
        productPostRequestDTO.setShortDescription("mo ta ngan");
        productPostRequestDTO.setTotalLike(11);
        productPostRequestDTO.setTotalReport(11);
        productPostRequestDTO.setTotalShare(11);
        productPostRequestDTO.setTypeDeal(11);
        productPostRequestDTO.setUser(null);
        productPostRequestDTO.setStatus(true);


        ProductPost productPost = new ProductPost();
        productPost.setId(1L);
        productPost.setProduct(null);
        productPost.setAddress("Dia chi");
        productPost.setContent("noi dung");
        productPost.setProductPostTitle("tieu de");
        productPost.setDistrict(null);
        productPost.setProvince(null);
        productPost.setWard(null);
        productPost.setShortDescription("mo ta ngan");
        productPost.setTotalLike(11);
        productPost.setTotalReport(11);
        productPost.setTotalShare(11);
        productPost.setTypeDeal(11);
        productPost.setUser(null);
        productPost.setStatus(true);

        ProductPostType productPostType = new ProductPostType();
        productPostType.setId(1L);
        productPostType.setProductPostTypeName("Mua");

        Optional<ProductPost> oprotion =  Optional.of(productPost);
        when(productPostRepository.findById(productPostRequestDTO.getId())).thenReturn(oprotion);
        Optional<ProductPostType> oprotion2 =  Optional.of(productPostType);
        when(postTypeRepository.findById(productPostRequestDTO.getProductPostType())).thenReturn(oprotion2);
        when(productPostRepository.save(Mockito.any(ProductPost.class))).thenReturn(productPost);

        ProductPostRequestDTO expect = new ProductPostRequestDTO();
        expect = productPostRequestDTO;
        ProductPost actual = productPostService.update(productPostRequestDTO).orElse(null);

        String gsExect = gs.toJson(expect.getContent());
        String gsActual = gs.toJson(actual.getContent());

        assertEquals(gsExect, gsActual);
    }

    @Test
    public void updateLikedTest(){
        Gson gs = new Gson();
        ProductPostRequestDTO productPostRequestDTO = new ProductPostRequestDTO();
        productPostRequestDTO.setId(1L);
        productPostRequestDTO.setProduct(null);
        productPostRequestDTO.setAddress("Dia chi");
        productPostRequestDTO.setContent("noi dung");
        productPostRequestDTO.setProductPostTitle("tieu de");
        productPostRequestDTO.setDistrict(null);
        productPostRequestDTO.setProvince(null);
        productPostRequestDTO.setWard(null);
        productPostRequestDTO.setShortDescription("mo ta ngan");
        productPostRequestDTO.setTotalLike(11);
        productPostRequestDTO.setTotalReport(11);
        productPostRequestDTO.setTotalShare(11);
        productPostRequestDTO.setTypeDeal(11);
        productPostRequestDTO.setUser(null);
        productPostRequestDTO.setStatus(true);

        ProductPost productPost = new ProductPost();
        productPost.setId(1L);
        productPost.setProduct(null);
        productPost.setAddress("Dia chi");
        productPost.setContent("noi dung");
        productPost.setProductPostTitle("tieu de");
        productPost.setDistrict(null);
        productPost.setProvince(null);
        productPost.setWard(null);
        productPost.setShortDescription("mo ta ngan");
        productPost.setTotalLike(11);
        productPost.setTotalReport(11);
        productPost.setTotalShare(11);
        productPost.setTypeDeal(11);
        productPost.setUser(null);
        productPost.setStatus(true);

        Optional<ProductPost> oprotion =  Optional.of(productPost);
        when(productPostRepository.findById(productPostRequestDTO.getId())).thenReturn(oprotion);
        when(productPostRepository.save(Mockito.any(ProductPost.class))).thenReturn(productPost);

        int expect = 10;

        ProductPost actual = productPostService.updateLiked(1L,10).orElse(null);

        assertEquals((Integer) expect,  actual.getTotalLike());
    }

    @Test
    public void deleteProductPostTest(){
        ProductPost productPost = new ProductPost();
        productPost.setId(1L);
        productPost.setProduct(null);
        productPost.setAddress("Dia chi");
        productPost.setContent("noi dung");
        productPost.setProductPostTitle("tieu de");
        productPost.setDistrict(null);
        productPost.setProvince(null);
        productPost.setWard(null);
        productPost.setShortDescription("mo ta ngan");
        productPost.setTotalLike(11);
        productPost.setTotalReport(11);
        productPost.setTotalShare(11);
        productPost.setTypeDeal(11);
        productPost.setUser(null);
        productPost.setStatus(true);
        Optional<ProductPost> oprotion =  Optional.of(productPost);
        when(productPostRepository.findById(1L)).thenReturn(oprotion);
        when(productPostRepository.save(Mockito.any(ProductPost.class))).thenReturn(productPost);

        productPostService.deleteByID(1L);
        assertEquals(false, productPost.isStatus());
    }

    /**
     * Product Service Test
     * */
    @Test
    public void findAllProductTest(){
        Gson gs = new Gson();
        List<Product> lst = new ArrayList<>();

        lst.add(new Product(111L,111L,null,null,11,22,33,null,null,null,true));
        lst.add(new Product(222L,222L,null,null,44,55,66,null,null,null,true));
        lst.add(new Product(333L,333L,null,null,77,88,99,null,null,null,true));
        when(productRepository.findAll()).thenReturn(lst);
        List<Product> lstExpect = lst;
        List<Product> lstActual = productService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllProductTypeTest(){
        Gson gs = new Gson();
        List<Product> lst = new ArrayList<>();
        lst.add(new Product(111L,111L,null,null,11,22,33,null,new ProductType("Nha"),null,true));
        lst.add(new Product(222L,222L,null,null,44,55,66,null,new ProductType("Nha"),null,true));
        lst.add(new Product(333L,333L,null,null,77,88,99,null,new ProductType("Nha"),null,true));
        when(productRepository.findAllByProductTypeId(1L)).thenReturn(lst);
        List<Product> lstExpect = lst;
        List<Product> lstActual = productService.findAllByProdcutType(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllProductTypeChildTest(){
        Gson gs = new Gson();
        List<Product> lst = new ArrayList<>();
        lst.add(new Product(111L,111L,null,null,11,22,33,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst.add(new Product(222L,222L,null,null,44,55,66,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst.add(new Product(333L,333L,null,null,77,88,99,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        when(productRepository.findAllByProductTypeChildId(1L)).thenReturn(lst);
        List<Product> lstExpect = lst;
        List<Product> lstActual = productService.findAllByProdcutTypeChild(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllProductbyIdTest(){
        Gson gs = new Gson();
        Optional<Product> product = Optional.of(new Product(111L,111L,null,null,11,22,33,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        productRepository.save(new Product(111L,111L,null,null,11,22,33,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        productRepository.save(new Product(222L,222L,null,null,44,55,66,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        productRepository.save(new Product(333L,333L,null,null,77,88,99,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        when(productRepository.findById(1L)).thenReturn(product);
        Optional<Product> lstExpect = product;
        Optional<Product> lstActual = productService.findByID(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void createProductTest(){
        Gson gson = new Gson();

        List<Long> longId = new ArrayList<>();
        longId.add(1L);
        longId.add(2L);
        longId.add(4L);

        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setId(1L);
        productRequestDTO.setArea(11L);
        productRequestDTO.setDirection(null);
        productRequestDTO.setLegalStatus(null);
        productRequestDTO.setNumberBathroom(11);
        productRequestDTO.setNumberBedroom(22);
        productRequestDTO.setNumberFloor(33);
        productRequestDTO.setPrice(1111L);
        productRequestDTO.setProductType(null);
        productRequestDTO.setProductTypeChild(null);
        productRequestDTO.setUtilities(longId);
        productRequestDTO.setStatus(true);
        List<Product> lst2 = new ArrayList<>();
        lst2.add(new Product(111L,111L,null,null,11,22,33,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst2.add(new Product(222L,222L,null,null,44,55,66,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst2.add(new Product(333L,333L,null,null,77,88,99,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));

        List<Utilities> lstUti = new ArrayList<>();
        lstUti.add(new Utilities("Dep",lst2));

        Product product = new Product();
        product.setId(1L);
        product.setArea(11L);
        product.setDirection(null);
        product.setLegalStatus(null);
        product.setNumberBathroom(11);
        product.setNumberBedroom(22);
        product.setNumberFloor(33);
        product.setPrice(1111L);
        product.setProductType(null);
        product.setProductTypeChild(null);
        product.setUtilities(lstUti);
        product.setStatus(true);
        List<Product> lst = new ArrayList<>();
        lst.add(new Product(111L,111L,null,null,11,22,33,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst.add(new Product(222L,222L,null,null,44,55,66,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst.add(new Product(333L,333L,null,null,77,88,99,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));

        Utilities utilities = new Utilities();
        utilities.setId(1L);
        utilities.setProduct(lst);
        utilities.setUtilitiesName("name");
        Optional<Utilities> oprotion =  Optional.of(utilities);
        when(utilitiesRepository.findById(1L)).thenReturn(oprotion);
        when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        Product expect = new Product();
        expect = product;

        Product actual = new Product();
        actual = productService.createProduct(productRequestDTO);

        String gsExect = gson.toJson(expect);
        String gsActual = gson.toJson(actual);

        assertEquals(gsExect, gsActual);
    }

    @Test
    public void updateProductTest(){
        Gson gs = new Gson();

        List<Long> longId = new ArrayList<>();
        longId.add(1L);
        longId.add(2L);
        longId.add(4L);

        ProductRequestDTO productRequestDTO = new ProductRequestDTO();
        productRequestDTO.setId(1L);
        productRequestDTO.setArea(11L);
        productRequestDTO.setDirection(null);
        productRequestDTO.setLegalStatus(null);
        productRequestDTO.setNumberBathroom(11);
        productRequestDTO.setNumberBedroom(22);
        productRequestDTO.setNumberFloor(33);
        productRequestDTO.setPrice(1111L);
        productRequestDTO.setProductType(null);
        productRequestDTO.setProductTypeChild(null);
        productRequestDTO.setUtilities(longId);
        productRequestDTO.setStatus(true);

        List<Product> lst2 = new ArrayList<>();
        lst2.add(new Product(111L,111L,null,null,11,22,33,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst2.add(new Product(222L,222L,null,null,44,55,66,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst2.add(new Product(333L,333L,null,null,77,88,99,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        List<Utilities> lstUti = new ArrayList<>();
        lstUti.add(new Utilities("Dep",lst2));

        Product product = new Product();
        product.setId(1L);
        product.setArea(11L);
        product.setDirection(null);
        product.setLegalStatus(null);
        product.setNumberBathroom(11);
        product.setNumberBedroom(22);
        product.setNumberFloor(33);
        product.setPrice(1111L);
        product.setProductType(null);
        product.setProductTypeChild(null);
        product.setUtilities(lstUti);
        product.setStatus(true);
        List<Product> lst = new ArrayList<>();
        lst.add(new Product(111L,111L,null,null,11,22,33,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst.add(new Product(222L,222L,null,null,44,55,66,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));
        lst.add(new Product(333L,333L,null,null,77,88,99,new ProductTypeChild(new ProductType("Can ho"),"shopHouse"),new ProductType("Can ho"),null,true));

        Utilities utilities = new Utilities();
        utilities.setId(1L);
        utilities.setProduct(lst);
        utilities.setUtilitiesName("name");
        Optional<Utilities> oprotion =  Optional.of(utilities);
        when(utilitiesRepository.findById(1L)).thenReturn(oprotion);
        Optional<Product> oprotion2 =  Optional.of(product);
        when(productRepository.findById(productRequestDTO.getId())).thenReturn(oprotion2);
        when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);

        Product expect = new Product();
        expect = product;
        Product actual = productService.updateProduct(productRequestDTO).orElse(null);

        String gsExect = gs.toJson(expect);
        String gsActual = gs.toJson(actual);

        assertEquals(gsExect, gsActual);
    }

    /**
     * Product type child service test
     * */
    @Test
    public void findAllByProductTypeChildTest(){
        Gson gs = new Gson();
        List<ProductTypeChild> lst = new ArrayList<>();
        lst.add(new ProductTypeChild(new ProductType("Nha1"),"Nha Dat1"));
        lst.add(new ProductTypeChild(new ProductType("Nha2"),"Nha Dat2"));
        lst.add(new ProductTypeChild(new ProductType("Nha3"),"Nha Dat3"));
        when(productTypeChildRepository.findAllByProductType_Id(1L)).thenReturn(lst);
        List<ProductTypeChild> lstExpect = lst;
        List<ProductTypeChild> lstActual = productTypeChildService.findAllByProductType(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }
    /**
     * Product type service test
     * */
    @Test
    public void findAllByProductTypeTest(){
        Gson gs = new Gson();
        List<ProductType> lst = new ArrayList<>();
        lst.add(new ProductType("Nha Dat1"));
        lst.add(new ProductType("Nha Dat2"));
        lst.add(new ProductType("Nha Dat3"));
        when(productTypeRepository.findAll()).thenReturn(lst);
        List<ProductType> lstExpect = lst;
        List<ProductType> lstActual = productTypeService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    /**
     * Review service test
     * */
    @Test
    public void findAllReviewTest(){
        Gson gs = new Gson();
        List<Review> lst = new ArrayList<>();
        lst.add(new Review(null,"abc",11,22,33,null,null,null,"abc","bcd",true,"anhDep",true));
        lst.add(new Review(null,"abc",44,55,66,null,null,null,"abc","bcd",true,"anhDep",true));
        lst.add(new Review(null,"abc",77,88,99,null,null,null,"abc","bcd",true,"anhDep",true));
        when(reviewRepository.findAll()).thenReturn(lst);
        List<Review> lstExpect = lst;
        List<Review> lstActual = reviewService.findAll();
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }

    @Test
    public void findAllReviewByIdTest(){
        Gson gs = new Gson();
        List<Review> lst = new ArrayList<>();
        Optional<Review> review = Optional.of(new Review(null,"abc",11,22,33,null,null,null,"abc","bcd",true,"anhDep",true));
        lst.add(new Review(null,"abc",11,22,33,null,null,null,"abc","bcd",true,"anhDep",true));
        lst.add(new Review(null,"abc",44,55,66,null,null,null,"abc","bcd",true,"anhDep",true));
        lst.add(new Review(null,"abc",77,88,99,null,null,null,"abc","bcd",true,"anhDep",true));
        when(reviewRepository.findById(1L)).thenReturn(review);
        Optional<Review> lstExpect = review;
        Optional<Review> lstActual = reviewService.findById(1L);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);
    }
    @Test
    public void findAllReviewByUserIdTest(){
        Gson gs = new Gson();
        Page<Review> lst = null;
        lst.getContent().add(new Review(new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null),"abc",11,22,33,null,null,null,"abc","bcd",true,"anhDep",true));
        lst.getContent().add(new Review(new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null),"abc",44,55,66,null,null,null,"abc","bcd",true,"anhDep",true));
        lst.getContent().add(new Review(new User("don123","123abc","ngo","van","fdfsdf",null,null,null,null,"01223232",true,"abc.com",true,null,"abc",null,null,null,null),"abc",77,88,99,null,null,null,"abc","bcd",true,"anhDep",true));
        when(reviewRepository.findAllByStatusIsTrueAndUserId(1L, null)).thenReturn(lst);
        Page<Review> lstExpect = lst;
        Page<Review> lstActual = reviewService.findByUserId(1L, null);
        String expect = gs.toJson(lstExpect);
        String actual = gs.toJson(lstActual);
        assertEquals(expect, actual);

    }
    @Test
    public void updateReviewLikedTest(){
        Gson gs = new Gson();
        ReviewRequestDTO reviewRequestDTO = new ReviewRequestDTO();
        reviewRequestDTO.setId(1L);
        reviewRequestDTO.setContent("Content");
        reviewRequestDTO.setDecription("Decription");
        reviewRequestDTO.setImageUrl("Image 1");
        reviewRequestDTO.setDistrict(null);
        reviewRequestDTO.setProvince(null);
        reviewRequestDTO.setWard(null);
        reviewRequestDTO.setTitle("Title");
        reviewRequestDTO.setTotalLike(11);
        reviewRequestDTO.setTotalReport(11);
        reviewRequestDTO.setTotalShare(11);
        reviewRequestDTO.setType(true);
        reviewRequestDTO.setUser(null);
        reviewRequestDTO.setStatus(true);

        Review review = new Review();
        review.setId(1L);
        review.setContent("Content");
        review.setDecription("Decription");
        review.setImageUrl("Image 1");
        review.setDistrict(null);
        review.setProvince(null);
        review.setWard(null);
        review.setTitle("Title");
        review.setTotalLike(11);
        review.setTotalReport(11);
        review.setTotalShare(11);
        review.setType(true);
        review.setUser(null);
        review.setStatus(true);

        Optional<Review> oprotion =  Optional.of(review);
        when(reviewRepository.findById(reviewRequestDTO.getId())).thenReturn(oprotion);
        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);

        int expect = 10;

        Review actual = reviewService.updateLiked(1L,10).orElse(null);

        assertEquals((Integer) expect,  actual.getTotalLike());
    }

    @Test
    public void createReviewTest(){
        Gson gs = new Gson();
        ReviewRequestDTO reviewRequestDTO = new ReviewRequestDTO();
        reviewRequestDTO.setId(1L);
        reviewRequestDTO.setContent("Content");
        reviewRequestDTO.setDecription("Decription");
        reviewRequestDTO.setImageUrl("Image 1");
        reviewRequestDTO.setDistrict(null);
        reviewRequestDTO.setProvince(null);
        reviewRequestDTO.setWard(null);
        reviewRequestDTO.setTitle("Title");
        reviewRequestDTO.setTotalLike(11);
        reviewRequestDTO.setTotalReport(11);
        reviewRequestDTO.setTotalShare(11);
        reviewRequestDTO.setType(true);
        reviewRequestDTO.setUser(null);
        reviewRequestDTO.setStatus(true);

        Review review = new Review();
        review.setId(1L);
        review.setContent("Content");
        review.setDecription("Decription");
        review.setImageUrl("Image 1");
        review.setDistrict(null);
        review.setProvince(null);
        review.setWard(null);
        review.setTitle("Title");
        review.setTotalLike(11);
        review.setTotalReport(11);
        review.setTotalShare(11);
        review.setType(true);
        review.setUser(null);
        review.setStatus(true);

        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);

        Review expect = new Review();
        expect = review;

        ReviewRequestDTO actual = new ReviewRequestDTO();
        actual = reviewRequestDTO;

        assertEquals(expect.getContent(), actual.getContent());
        assertEquals(expect.getDistrict(), actual.getDistrict());
        assertEquals(expect.getDecription(), actual.getDecription());
        assertEquals(expect.getWard(), actual.getWard());
        assertEquals(expect.getTitle(), actual.getTitle());
    }

    @Test
    public void updateReviewTest(){
        Gson gs = new Gson();
        ReviewRequestDTO reviewRequestDTO = new ReviewRequestDTO();
        reviewRequestDTO.setId(1L);
        reviewRequestDTO.setContent("Content");
        reviewRequestDTO.setDecription("Decription");
        reviewRequestDTO.setImageUrl("Image 1");
        reviewRequestDTO.setDistrict(null);
        reviewRequestDTO.setProvince(null);
        reviewRequestDTO.setWard(null);
        reviewRequestDTO.setTitle("Title");
        reviewRequestDTO.setTotalLike(11);
        reviewRequestDTO.setTotalReport(11);
        reviewRequestDTO.setTotalShare(11);
        reviewRequestDTO.setType(true);
        reviewRequestDTO.setUser(null);
        reviewRequestDTO.setStatus(true);

        Review review = new Review();
        review.setId(1L);
        review.setContent("Content");
        review.setDecription("Decription");
        review.setImageUrl("Image 1");
        review.setDistrict(null);
        review.setProvince(null);
        review.setWard(null);
        review.setTitle("Title");
        review.setTotalLike(11);
        review.setTotalReport(11);
        review.setTotalShare(11);
        review.setType(true);
        review.setUser(null);
        review.setStatus(true);
        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);

        Optional<Review> oprotion =  Optional.of(review);
        when(reviewRepository.findById(reviewRequestDTO.getId())).thenReturn(oprotion);

        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);

        ReviewRequestDTO expect = new ReviewRequestDTO();
        expect = reviewRequestDTO;
        Review actual = reviewService.updateReview(reviewRequestDTO).orElse(null);

        assertEquals(expect.getContent(), actual.getContent());
        assertEquals(expect.getDistrict(), actual.getDistrict());
        assertEquals(expect.getDecription(), actual.getDecription());
        assertEquals(expect.getWard(), actual.getWard());
        assertEquals(expect.getTitle(), actual.getTitle());
    }

    @Test
    public void deleteReviewTest(){
        Review review = new Review();
        review.setId(1L);
        review.setContent("Content");
        review.setDecription("Decription");
        review.setImageUrl("Image 1");
        review.setDistrict(null);
        review.setProvince(null);
        review.setWard(null);
        review.setTitle("Title");
        review.setTotalLike(11);
        review.setTotalReport(11);
        review.setTotalShare(11);
        review.setType(true);
        review.setUser(null);
        review.setStatus(true);
        Optional<Review> oprotion =  Optional.of(review);
        when(reviewRepository.findById(1L)).thenReturn(oprotion);
        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);

        reviewService.deleteReview(1L);
        assertEquals(false, review.isStatus());

    }
}
