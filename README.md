# Inventory App documentation

This is a REST controller to manage products in an inventory application. It provides CRUD operations (Create, Read, Update, and Delete) for the products.

The project is built with Spring Boot and follows REST principles to handle products in the database.


## Installation

1. Clone this repository:

```bash
https://github.com/PhariusHS/InventoryAppJava.git
```


## API ENDPOINTS

### Get all products

- **URL**: `/products`
- **Method**: `GET`
- **Description**: Returns a list of all products in the database.
  
  **Example response**:
```json
[
    {
        "id": 1,
        "name": "Product 1",
        "stock": 100
    },
    {
        "id": 2,
        "name": "Product 2",
        "stock": 50
    }
]
```

### Get product by ID

- **URL**: `/products/{id}`
- **Method**: `GET`
- **Description**: Returns a product by its id.
- **Parameter**:
  - `id` (Long): Product id
    
**Example response (id = 1)**:

```json
    {
        "id": 1,
        "name": "Product 1",
        "stock": 100
    }
```




