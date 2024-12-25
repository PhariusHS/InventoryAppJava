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


## API ENDPOINTS
- **URL**:
`/products`
`/establishments`
`/restock`
`/inventory`
`/type` -(Type Of Product)-


## EXAMPLES OF USE
### Get all 
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

### Get by ID

- **URL**: `/establishments/{id}`
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




