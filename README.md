# Inventory App documentation

In this application, we have several establishments that need to restock their centers.
Every establishment has an inventory with a list of products and their available stock.

When an establishment needs to restock itself, it generates a restock request based on its inventory.
Once the restock is completed, the inventory quantities will decrease.


## Installation

1. Clone this repository:

```bash
https://github.com/PhariusHS/InventoryAppJava.git
```
2. Execute docker compose in project terminal:
```bash
Docker-compose up
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

```
{
"message":"User successfully created",
"token":"authTokenExample"
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

```
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
            "name": "Beer"
        }
    },
    {
        "productId": 2,
        "name": "Product name 2",
        "typeOfProduct": {
            "typeOfProductId": 1,
            "name": "Wine"
        }
    },
    ...
```

### Get by ID

- **URL**: `/product/{id}`
- **Method**: `GET`
- **Description**: Returns a product by id.
- **Parameter**:
  - `id` (Long): Product id
    
**Example response (id = 1)**:

```json
  {
        "productId": 1,
        "name": "Product name 2",
        "typeOfProduct": {
            "typeOfProductId": 1,
            "name": "Beer"
        }
  }
```

### Create
- **URL**: `/product?typeOfProductId=1`
- **Method**: `POST`
- **Description**: Creates a new product.
- **Parameter**:
  - `TypeOfProductId` (Long): Type of product id
    

**Example body:**
```body
{   
        "name": "Product name 3"
}
```
**Example response (typeOfProductId = 1)**:
```json
  {
        "productId": 3,
        "name": "Product name 3",
        "typeOfProduct": {
            "typeOfProductId": 1,
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
```body
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
