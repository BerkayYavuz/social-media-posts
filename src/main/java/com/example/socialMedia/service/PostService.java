package com.example.socialMedia.service;

import com.example.socialMedia.exception.PostNotFoundException;
import com.example.socialMedia.exception.InvalidPostException;
import com.example.socialMedia.model.Post;
import com.example.socialMedia.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Tüm gönderileri getir
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    // ID'ye göre gönderiyi getir, yoksa hata fırlat
    public Post getPostById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException( id + " Bu ID numarasında bir post bulunamadı."));
    }

    // Gönderi oluştur, validasyon uygula
    public Post createPost(Post post) {
        if (post.getTitle() == null || post.getTitle().isEmpty()) {
            throw new InvalidPostException("Post Başlığı boş olamaz. Lütfen Başlık giriniz");
        }
        if (post.getContent() == null || post.getContent().isEmpty()) {
            throw new InvalidPostException("Post içeriği boş olamaz. Lütfen içerik giriniz");
        }
        return postRepository.save(post);
    }

    // Gönderiyi sil, gönderi yoksa hata fırlat
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new PostNotFoundException("Bu ID'de post bulamadık post ID : " + id + " Bu yüzden de silemedik.");
        }
        postRepository.deleteById(id);
    }
}
