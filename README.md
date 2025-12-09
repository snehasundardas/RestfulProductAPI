# RestfulProductAPI

## Overview
RestfulProductAPI is a robust Java-based backend project providing RESTful APIs for managing products. The application allows users to filter and sort products efficiently, enabling dynamic and responsive product queries for any frontend or client application.

The project uses **JSON** for data exchange and has been thoroughly tested using **Postman** to ensure API reliability and performance.

---

## Features
- **Multiple Endpoints**: Provides various endpoints for CRUD operations on products.
- **Filtering**: Retrieve products based on **brand** and **category**.
- **Sorting**: Sort products based on **price**, either ascending or descending.
- **Data Exchange**: Uses JSON for communication between client and server.
- **Testing**: APIs tested using Postman to validate responses and error handling.

---

## Technologies Used
- Java (Spring Boot recommended)
- JSON
- RESTful API Design
- Postman (API testing)

---

## API Endpoints
Here are some example endpoints:

| Endpoint                  | Method | Description                                  |
|----------------------------|--------|----------------------------------------------|
| `/products`                | GET    | Fetch all products                           |
| `/products?brand=BrandX`   | GET    | Filter products by brand                     |
| `/products?category=CatY`  | GET    | Filter products by category                  |
| `/products?sort=price`     | GET    | Sort products by price (ascending by default) |

> Note: Query parameters can be combined for filtering and sorting simultaneously.

---

## Usage

1. **Clone the repository**:

```bash
git clone https://github.com/snehasundardas/RestfulProductAPI.git
