# Inventory App documentation

In this application, we have several establishments that need to restock their centers.
Every establishment has an inventory with a list of products and their available stock.

When an establishment needs to restock itself, it generates a restock request based on its inventory.
Once the restock is completed, the inventory quantities will decrease.

# Architecture
This project follows a layered architecture to ensure a clean separation of responsibilities and easy maintenance.

### Layers:

- **Controller:** Handles incoming HTTP requests and responses, delegating business logic to the service layer.
- **Middleware:** Manages authentication, authorization, and request processing before reaching the service layer.
- **Service:** Implements business logic, processes data, and interacts with the repository layer.
- **Model:** Defines the application's data structures and represents database entities.
- **Repository:** Manages data persistence and retrieval, interacting directly with the database.
  
### Global Layer:
- **Exception Handler:** Centralized error handling to manage and return meaningful responses across the application.


## Installation

1. Clone this repository:

```bash
https://github.com/PhariusHS/InventoryAppJava.git
```
2. Execute docker compose in project terminal:
```bash
Docker-compose up
```
3. Configure your environment variables files with the repository template:
```bash
.env.template
```

# AUTH ENDPOINTS: 
- **URL**:
- `/auth/register`
- `/auth/login`

## REGISTER AND LOGIN EXAMPLE
### Register 
- **Method**: `POST`
- **Description**: Creates a new user and returns an Auth token.
  
  **Example body**:
```json
 {
    "country": "Argentina",
    "firstName": "Pedro",
    "lastName": "González",
    "password": "passwordExample",
    "username": "usernameExample"
}
```

#### RETURNS:

```json
{
    "message": "User successfully created",
    "token": "authTokenExample"
}

```

### Login 
- **Method**: `POST`
- **Description**: Creates a new user and returns an Auth token.
  
  **Example body**:
```json
 {
    "username": "usernameExample",
    "password": "passwordExample"
}
```

#### RETURNS:

```json
{
    "message": "Successfully log in",
    "token": "authTokenExample"
}

```

  # API ENDPOINTS

- **URL**:
- `/product`
- `/establishment`
- `/restock`
- `/inventory`
- `/type` -(Type Of Product)-
- `/restock/product`
- `/inventory/product`

## EXAMPLES OF USE

#### Get all 
- **URL**: `/product`
- **Method**: `GET`
- **Description**: Returns a list of all products in the database.
  
  **Example response**:
```json
[
    {
        "productId": 1,
        "name": "Product name 2",
        "typeOfProduct": {
            "typeOfProductId": 1,
            "name": "Wine"
        }
    },
    {
        "productId": 2,
        "name": "Product name 2",
        "typeOfProduct": {
            "typeOfProductId": 2,
            "name": "Beer"
        }
    },
    ...
]
```

### Get by ID

- **URL**: `/product/{id}`
- **Method**: `GET`
- **Description**: Returns a product by id.
- **Parameter**:
  - `id` (Long): Product id
    
**Example response (id = 2)**:

```json
  {
        "productId": 1,
        "name": "Product name 2",
        "typeOfProduct": {
            "typeOfProductId": 2,
            "name": "Beer"
        }
  }
```

### Create
- **URL**: `/product?typeOfProductId=2`
- **Method**: `POST`
- **Description**: Creates a new product.
- **Parameter**:
  - `TypeOfProductId` (Long): Type of product id
    

**Example body:**
```json
{   
        "name": "Product name 3"
}
```
**Example response (typeOfProductId = 2)**:
```json
  {
        "productId": 3,
        "name": "Product name 3",
        "typeOfProduct": {
            "typeOfProductId": 2,
            "name": "Beer"
        }
  }
```

### Update
- **URL**: `/product/{id}`
- **Method**: `PUT`
- **Description**: Updates the product.
- **Parameter**:
  - `id` (Long): Product id
    

**Example body:**
```json
{
    "name":"Chardonnay PDB",
    "typeOfProduct": {
        "typeOfProductId": 1
    }
}
```
**Example response (Changes the name and type)**:
```json
{
    "productId": 3,
    "name": "Chardonnay PDB",
    "typeOfProduct": {
        "typeOfProductId": 1,
        "name": "Vini"
    }
}
```




