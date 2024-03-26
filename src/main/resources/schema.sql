CREATE TABLE catalog (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         product_id VARCHAR(120) NOT NULL UNIQUE,
                         product_name VARCHAR(255) NOT NULL,
                         stock INTEGER NOT NULL,
                         unit_price INTEGER NOT NULL,
                         created_at DATE DEFAULT CURRENT_DATE NOT NULL
);
