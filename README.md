# Trendyoliki - E-Commerce Backend

A Spring Boot REST API project inspired by Trendyol.

## Tech Stack
- Java 21 + Spring Boot 4
- Spring Security (Basic Auth)
- MySQL + Hibernate
- HTML/CSS/JS (Frontend)

## Features
- Product listing & filtering
- Category management
- Shopping cart
- Order management
- Role-based access (Admin, Seller, Customer)
- Image upload

## Setup
1. Clone the repo
2. Create MySQL database: `ecommerce_db`
3. Update `application.properties` with your DB credentials
4. Run the project

## API Endpoints
| Method | URL | Access |
|--------|-----|--------|
| GET | /api/products | Public |
| GET | /api/categories | Public |
| POST | /api/products | Seller |
| GET | /api/cartItems | Customer |
| GET | /api/orders | Customer |
| GET | /api/users | Admin |
