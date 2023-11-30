package com.phatvo.economic.repository;

import com.phatvo.economic.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Các phương thức tùy chỉnh nếu cần
    // Điều này là tùy chọn, không cần phải có nếu không cần thiết
}

