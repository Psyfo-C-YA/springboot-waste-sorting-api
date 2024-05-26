# Waste Sorting Application

Enviro365's Waste Sorting Application is designed to promote sustainable waste management practices by providing guidelines for waste disposal and recycling tips. This application is implemented using Spring Boot and follows best practices in software design, including separation of concerns, dependency injection, and the use of DTOs (Data Transfer Objects) for data transfer.

## Overview

This application consists of the following main entities:
- **WasteCategory**: Represents a category of waste (e.g., Plastic).
- **DisposalGuideline**: Represents guidelines for disposing of waste.
- **RecyclingTip**: Represents tips for recycling.

The API exposes several endpoints to manage these entities.

## Prerequisites

- Java 17 or later
- intelliJ community edition

## Getting Started

Clone the repository:
   ```cmd/terminal
   git clone https://github.com/yourusername/waste-sorting-app.git
   cd waste-sorting-app
   ```
##  API Endpoints
### Waste Categories

### Get All Waste Categories
- URL: `/api/waste-categories`
- Method: `GET`
- Response :
```
  [
    {
        "id": 1,
        "name": "Plastic",
        "disposalGuidelines": [
            {
                "id": 1,
                "description": "Dispose of in general waste"
            }
        ],
        "tips": [
            {
                "id": 1,
                "tip": "sort with other like materials"
            }
        ]
    }
]
```


### Get a Specific Waste Category by ID
- URL: `/api/waste-categories/{id}`
- Method: `GET`
- Response :
```
  [
    {
        "id": 1,
        "name": "Plastic",
        "disposalGuidelines": [
            {
                "id": 1,
                "description": "Dispose of in general waste"
            }
        ],
        "tips": [
            {
                "id": 1,
                "tip": "sort with other like materials"
            }
        ]
    }
]
```

### Get a Specific Waste Category by Name
- URL: `/api/waste-categories/name/{name}`
- Method: `GET`
- Response :
```
  [
    {
        "id": 1,
        "name": "Plastic",
        "disposalGuidelines": [
            {
                "id": 1,
                "description": "Dispose of in general waste"
            }
        ],
        "tips": [
            {
                "id": 1,
                "tip": "sort with other like materials"
            }
        ]
    }
]
```

### Create a New Waste Category
- URL: `/api/waste-categories`
- Method: `POST`
- Request Body:
```
{
    "name": "Plastic"
}

```
- Response Status: `200 OK`

### Update an Existing Waste Category
- URL: `/api/waste-categories/{id}`
- Method: `PUT`
- Request Body:
```
{
    "name": "Updated Plastic"
}
```
- Response Status: `200 OK`

### Delete a Waste Category by ID
- URL: `/api/waste-categories/{id}`
- Method: `DELETE`
- Request Body:
- Response Status: `204 No Content`


### Disposal Guidelines

### Get All Disposal Guidelines
- URL: `/api/disposal-guidelines`
- Method: `GET`
- Response :
```
[
    {
        "id": 1,
        "description": "Dispose of in general waste"
    }
]
```

### Get a Specific Disposal Guideline by ID
- URL: `/api/disposal-guidelines/{id}`
- Method: `GET`
- Response :
```
{
  "id": 1,
  "description": "Dispose of in general waste"
}
```

### Create a New Waste Category
- URL: `/api/disposal-guidelines`
- Method: `POST`
- Request Body:
```
{
  "description": "Dispose of in general waste"
}

```
- Response Status: `200 OK`

### Update an Existing Disposal Guideline
- URL: `/api/disposal-guidelines/1/guideline/1`
- Method: `PUT`
- Request Body:
```
{
  "description": "Updated guideline for disposal in general waste"
}

```
- Response Status: `200 OK`

### Delete a Waste Category by ID
- URL: `/api/disposal-guidelines/{id}`
- Method: `DELETE`
- Request Body:
- Response Status: `204 No Content`

### Recycling Tips

### Get All Recycling Tips
- URL: `/api/recycling-tips`
- Method: `GET`
- Response :
```
[
    {
        "id": 1,
        "description": "sort with other like materials"
    }
]
```

### Get a Specific Recycling Tip by ID
- URL: `/api/recycling-tips/{id}`
- Method: `GET`
- Response :
```
{
    "id": 1,
    "description": "sort with other like materials"
}
```

### Create a New Recycling Tip
- URL: `/api/recycling-tips`
- Method: `POST`
- Request Body:
```
{
    "tip" : "sort with other like materials"
}

```
- Response Status: `200 OK`

### Update an Existing Recycling Tip
- URL: `/api/recycling-tips/{id}/tip/{id}`
- Method: `PUT`
- Request Body:
```
{
    "tip" : "Updated tip to sort like material"
}


```
- Response Status: `200 OK`

### Delete a Recycling Tip by ID
- URL: `/api/recycling-tips/{id}`
- Method: `DELETE`
- Request Body:
- Response Status: `204 No Content`







   
