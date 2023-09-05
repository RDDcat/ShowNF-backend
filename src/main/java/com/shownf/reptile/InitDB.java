package com.shownf.reptile;

import com.shownf.reptile.Model.Enum.Category;
import com.shownf.reptile.Model.entity.*;
import com.shownf.reptile.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init(){
        initService.dbInit();
    }

    @Component
    @RequiredArgsConstructor
    static class InitService{

        private final PostRepositoryJPA postRepositoryJPA;
        private final PostContentRepositoryJPA postContentRepositoryJPA;
        private final PostHeartRepositoryJPA postHeartRepositoryJPA;
        private final CommentRepositoryJPA commentRepositoryJPA;
        private final CommentHeartRepositoryJPA commentHeartRepositoryJPA;
        private final ReplyRepositoryJPA replyRepositoryJPA;
        private final ReplyHeartRepositoryJPA replyHeartRepositoryJPA;
        private final ImageRepositoryJPA imageRepositoryJPA;
        private final ImageHeartRepositoryJPA imageHeartRepositoryJPA;
        private final SaleRepositoryJPA saleRepositoryJPA;
        private final SaleHeartRepositoryJPA saleHeartRepositoryJPA;

        public void dbInit(){
            PostDAO postDAO1 = new PostDAO(0, "코딩좀비", "테스트 제목1", "[{imageUrl=http://localhost:8080/test1.jpg, content=content1}, {imageUrl=http://localhost:8080/test2.jpg, content=content2}]", Category.FROG, LocalDateTime.now(), 3, 1, 0);
            PostDAO postDAO2 = new PostDAO(1, "괴물", "테스트 제목2", "[{imageUrl=http://localhost:8080/test3.jpg, content=content3}, {imageUrl=http://localhost:8080/test4.jpg, content=content4}]", Category.REPTILE, LocalDateTime.now(), 2, 6, 0);
            PostDAO postDAO3 = new PostDAO(2, "카페인중독", "테스트 제목3", "[{imageUrl=http://localhost:8080/test5.jpg, content=content5}, {imageUrl=http://localhost:8080/test6.jpg, content=content6}]", Category.SNAKE, LocalDateTime.now(), 0, 0, 0);
            PostDAO postDAO4 = new PostDAO(3, "코딩좀비", "테스트 제목4", "[{imageUrl=http://localhost:8080/test7.jpg, content=content7}, {imageUrl=http://localhost:8080/test8.jpg, content=content8}]", Category.TURTLE, LocalDateTime.now(), 4, 0, 0);
            PostDAO postDAO5 = new PostDAO(4, "괴물", "테스트 제목5", "[{imageUrl=http://localhost:8080/test9.jpg, content=content9}, {imageUrl=http://localhost:8080/test10.jpg, content=content10}]", Category.FROG, LocalDateTime.now(), 6, 0, 0);
            PostDAO postDAO6 = new PostDAO(5, "카페인중독", "테스트 제목6", "[{imageUrl=http://localhost:8080/test11.jpg, content=content11}, {imageUrl=http://localhost:8080/test12.jpg, content=content12}]", Category.REPTILE, LocalDateTime.now(), 2, 0, 0);
            PostDAO postDAO7 = new PostDAO(6, "괴물", "테스트 제목7", "[{imageUrl=http://localhost:8080/test13.jpg, content=content13}, {imageUrl=http://localhost:8080/test14.jpg, content=content14}]", Category.SNAKE, LocalDateTime.now(), 3, 0, 0);
            PostDAO postDAO8 = new PostDAO(7, "코딩좀비", "테스트 제목8", "[{imageUrl=http://localhost:8080/test15.jpg, content=content15}, {imageUrl=http://localhost:8080/test16.jpg, content=content16}]", Category.TURTLE, LocalDateTime.now(), 6, 0, 0);
            PostDAO postDAO9 = new PostDAO(8, "카페인중독", "테스트 제목9", "[{imageUrl=http://localhost:8080/test17.jpg, content=content17}, {imageUrl=http://localhost:8080/test18.jpg, content=content18}]", Category.FROG, LocalDateTime.now(), 9, 0, 0);
            PostDAO postDAO10 = new PostDAO(9, "괴물", "테스트 제목10", "[{imageUrl=http://localhost:8080/test19.jpg, content=content19}, {imageUrl=http://localhost:8080/test20.jpg, content=content20}]", Category.REPTILE, LocalDateTime.now(), 7, 0, 0);

            postRepositoryJPA.save(postDAO1);
            postRepositoryJPA.save(postDAO2);
            postRepositoryJPA.save(postDAO3);
            postRepositoryJPA.save(postDAO4);
            postRepositoryJPA.save(postDAO5);
            postRepositoryJPA.save(postDAO6);
            postRepositoryJPA.save(postDAO7);
            postRepositoryJPA.save(postDAO8);
            postRepositoryJPA.save(postDAO9);
            postRepositoryJPA.save(postDAO10);

            PostContentDAO postContentDAO1 = new PostContentDAO(100L, 0L, "http://localhost:8080/test1.jpg", "content1");
            PostContentDAO postContentDAO2 = new PostContentDAO(101L, 0L, "http://localhost:8080/test2.jpg", "content2");
            PostContentDAO postContentDAO3 = new PostContentDAO(102L, 1L, "http://localhost:8080/test3.jpg", "content3");
            PostContentDAO postContentDAO4 = new PostContentDAO(103L, 1L, "http://localhost:8080/test4.jpg", "content4");
            PostContentDAO postContentDAO5 = new PostContentDAO(104L, 2L, "http://localhost:8080/test5.jpg", "content5");
            PostContentDAO postContentDAO6 = new PostContentDAO(105L, 2L, "http://localhost:8080/test6.jpg", "content6");

            postContentRepositoryJPA.save(postContentDAO1);
            postContentRepositoryJPA.save(postContentDAO2);
            postContentRepositoryJPA.save(postContentDAO3);
            postContentRepositoryJPA.save(postContentDAO4);
            postContentRepositoryJPA.save(postContentDAO5);
            postContentRepositoryJPA.save(postContentDAO6);

            PostHeartDAO postHeartDAO1 = new PostHeartDAO(11L, postDAO1.getPostId(), "아이폰", LocalDateTime.now());
            PostHeartDAO postHeartDAO2 = new PostHeartDAO(12L, postDAO1.getPostId(), "갤럭시", LocalDateTime.now());
            PostHeartDAO postHeartDAO3 = new PostHeartDAO(13L, postDAO1.getPostId(), "모터롤라", LocalDateTime.now());
            PostHeartDAO postHeartDAO4 = new PostHeartDAO(14L, postDAO2.getPostId(), "베가", LocalDateTime.now());
            PostHeartDAO postHeartDAO5 = new PostHeartDAO(15L, postDAO2.getPostId(), "매직콜", LocalDateTime.now());

            postHeartRepositoryJPA.save(postHeartDAO1);
            postHeartRepositoryJPA.save(postHeartDAO2);
            postHeartRepositoryJPA.save(postHeartDAO3);
            postHeartRepositoryJPA.save(postHeartDAO4);
            postHeartRepositoryJPA.save(postHeartDAO5);

            CommentDAO commentDAO1 = new CommentDAO(0L, postDAO1.getPostId(), "토레타", "테스트 내용1", LocalDateTime.now(), 0, 0);
            CommentDAO commentDAO2 = new CommentDAO(1L, postDAO2.getPostId(), "파워에이드", "테스트 내용2", LocalDateTime.now(), 0, 0);
            CommentDAO commentDAO3 = new CommentDAO(2L, postDAO2.getPostId(), "콜라", "테스트 내용3", LocalDateTime.now(), 1, 2);
            CommentDAO commentDAO4 = new CommentDAO(3L, postDAO2.getPostId(), "사이다", "테스트 내용4", LocalDateTime.now(), 3, 1);

            commentRepositoryJPA.save(commentDAO1);
            commentRepositoryJPA.save(commentDAO2);
            commentRepositoryJPA.save(commentDAO3);
            commentRepositoryJPA.save(commentDAO4);

            CommentHeartDAO commentHeartDAO1 = new CommentHeartDAO(21L, commentDAO3.getCommentId(), "에어팟", LocalDateTime.now());
            CommentHeartDAO commentHeartDAO2 = new CommentHeartDAO(22L, commentDAO4.getCommentId(), "버즈", LocalDateTime.now());
            CommentHeartDAO commentHeartDAO3 = new CommentHeartDAO(23L, commentDAO4.getCommentId(), "소니", LocalDateTime.now());
            CommentHeartDAO commentHeartDAO4 = new CommentHeartDAO(24L, commentDAO4.getCommentId(), "엘지", LocalDateTime.now());

            commentHeartRepositoryJPA.save(commentHeartDAO1);
            commentHeartRepositoryJPA.save(commentHeartDAO2);
            commentHeartRepositoryJPA.save(commentHeartDAO3);
            commentHeartRepositoryJPA.save(commentHeartDAO4);

            ReplyDAO replyDAO1 = new ReplyDAO(0L, commentDAO3.getCommentId(), "토레타", "테스트내용0 입니당", LocalDateTime.now(), 1);
            ReplyDAO replyDAO2 = new ReplyDAO(1L, commentDAO3.getCommentId(), "파워에이드", "테스트내용1 입니당", LocalDateTime.now(), 2);
            ReplyDAO replyDAO3 = new ReplyDAO(2L, commentDAO4.getCommentId(), "사이다", "테스트내용1 입니당", LocalDateTime.now(), 0);

            replyRepositoryJPA.save(replyDAO1);
            replyRepositoryJPA.save(replyDAO2);
            replyRepositoryJPA.save(replyDAO3);

            ReplyHeartDAO replyHeartDAO1 = new ReplyHeartDAO(31L, replyDAO1.getReplyId(), "아이폰", LocalDateTime.now());
            ReplyHeartDAO replyHeartDAO2 = new ReplyHeartDAO(32L, replyDAO2.getReplyId(), "갤럭시", LocalDateTime.now());
            ReplyHeartDAO replyHeartDAO3 = new ReplyHeartDAO(33L, replyDAO2.getReplyId(), "매직콜", LocalDateTime.now());

            replyHeartRepositoryJPA.save(replyHeartDAO1);
            replyHeartRepositoryJPA.save(replyHeartDAO2);
            replyHeartRepositoryJPA.save(replyHeartDAO3);

            ImageDAO imageDAO1 = new ImageDAO(0L, "frog1.jpg", "http://localhost:8080/frog1.jpg", LocalDateTime.now(), 2);
            ImageDAO imageDAO2 = new ImageDAO(1L, "frog2.jpg", "http://localhost:8080/frog2.jpg", LocalDateTime.now(), 1);
            ImageDAO imageDAO3 = new ImageDAO(2L, "frog3.jpg", "http://localhost:8080/frog3.jpg", LocalDateTime.now(), 3);
            ImageDAO imageDAO4 = new ImageDAO(3L, "frog4.jpg", "http://localhost:8080/frog4.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO5 = new ImageDAO(4L, "frog5.jpg", "http://localhost:8080/frog5.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO6 = new ImageDAO(5L, "reptile1.jpg", "http://localhost:8080/reptile1.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO7 = new ImageDAO(6L, "reptile2.jpg", "http://localhost:8080/reptile2.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO8 = new ImageDAO(7L, "reptile3.jpg", "http://localhost:8080/reptile3.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO9 = new ImageDAO(8L, "reptile4.jpg", "http://localhost:8080/reptile4.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO10 = new ImageDAO(9L, "reptile5.jpg", "http://localhost:8080/reptile5.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO11 = new ImageDAO(10L, "snake1.jpg", "http://localhost:8080/snake1.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO12 = new ImageDAO(11L, "snake2.jpg", "http://localhost:8080/snake2.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO13 = new ImageDAO(12L, "snake3.jpg", "http://localhost:8080/snake3.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO14 = new ImageDAO(13L, "snake4.jpg", "http://localhost:8080/snake4.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO15 = new ImageDAO(14L, "snake5.jpg", "http://localhost:8080/snake5.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO16 = new ImageDAO(15L, "turtle1.jpg", "http://localhost:8080/turtle1.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO17 = new ImageDAO(16L, "turtle2.jpg", "http://localhost:8080/turtle2.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO18 = new ImageDAO(17L, "turtle3.jpg", "http://localhost:8080/turtle3.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO19 = new ImageDAO(18L, "turtle4.jpg", "http://localhost:8080/turtle4.jpg", LocalDateTime.now(), 0);
            ImageDAO imageDAO20 = new ImageDAO(19L, "turtle5.jpg", "http://localhost:8080/turtle5.jpg", LocalDateTime.now(), 0);

            imageRepositoryJPA.save(imageDAO1);
            imageRepositoryJPA.save(imageDAO2);
            imageRepositoryJPA.save(imageDAO3);
            imageRepositoryJPA.save(imageDAO4);
            imageRepositoryJPA.save(imageDAO5);
            imageRepositoryJPA.save(imageDAO6);
            imageRepositoryJPA.save(imageDAO7);
            imageRepositoryJPA.save(imageDAO8);
            imageRepositoryJPA.save(imageDAO9);
            imageRepositoryJPA.save(imageDAO10);
            imageRepositoryJPA.save(imageDAO11);
            imageRepositoryJPA.save(imageDAO12);
            imageRepositoryJPA.save(imageDAO13);
            imageRepositoryJPA.save(imageDAO14);
            imageRepositoryJPA.save(imageDAO15);
            imageRepositoryJPA.save(imageDAO16);
            imageRepositoryJPA.save(imageDAO17);
            imageRepositoryJPA.save(imageDAO18);
            imageRepositoryJPA.save(imageDAO19);
            imageRepositoryJPA.save(imageDAO20);

            ImageHeartDAO imageHeartDAO1 = new ImageHeartDAO(10L, imageDAO1.getImageId(), "24남", LocalDateTime.now());
            ImageHeartDAO imageHeartDAO2 = new ImageHeartDAO(11L, imageDAO1.getImageId(), "21여", LocalDateTime.now());
            ImageHeartDAO imageHeartDAO3 = new ImageHeartDAO(12L, imageDAO2.getImageId(), "17고딩남", LocalDateTime.now());
            ImageHeartDAO imageHeartDAO4 = new ImageHeartDAO(13L, imageDAO3.getImageId(), "25남", LocalDateTime.now());
            ImageHeartDAO imageHeartDAO5 = new ImageHeartDAO(14L, imageDAO3.getImageId(), "24남", LocalDateTime.now());
            ImageHeartDAO imageHeartDAO6 = new ImageHeartDAO(15L, imageDAO3.getImageId(), "23남", LocalDateTime.now());

            imageHeartRepositoryJPA.save(imageHeartDAO1);
            imageHeartRepositoryJPA.save(imageHeartDAO2);
            imageHeartRepositoryJPA.save(imageHeartDAO3);
            imageHeartRepositoryJPA.save(imageHeartDAO4);
            imageHeartRepositoryJPA.save(imageHeartDAO5);
            imageHeartRepositoryJPA.save(imageHeartDAO6);

            SaleDAO saleDAO1 = new SaleDAO(0L, "aa", "[{imageUrl=http://localhost:8080/test1.jpg}, {imageUrl=http://localhost:8080/test2.jpg}]", "개체", "첫번째 종", "두번째 종", "생일", 2.4, "개체 설명", 1111, 0);
            saleRepositoryJPA.save(saleDAO1);
        }
    }
}
