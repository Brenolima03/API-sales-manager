
Need to find a way to insert an order in the customer table

Customer payload:
{
    "name": "Maria Brown"
}

Product payload:
{
    "name": "The Lord of the Rings",
    "price": 90.5,
    "quantity": 2
}

Order payload:
{
    "datetime": "20/06/2019 19:53:07",
    "products": [
        {
            "id": 1,
            "name": "The Lord of the Rings",
            "price": 90.5,
            "quantity": 2,
            "subTotal": 181.0
        }
    ],
    "total": 181.0
}