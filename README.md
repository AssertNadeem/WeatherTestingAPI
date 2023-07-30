# WeatherTestingAPI
WeatherTestingAPI

This project is a simple representation of API requests automation testing.

**Automation:**

1. Language: Java
2. Maven is open-source build tool.
3. Extent Reporting

**Why Rest-assured is used.**
Rest Assured enables you to test REST APIs using java libraries and integrates well with Maven. 
It has very efficient matching techniques, so asserting your expected results is also pretty straight forward. 
Rest Assured has methods to fetch data from almost every part of the request and response no matter how complex the JSON structures are.
   
**API-Testing.**
1. API end point of Wellington city is captured and validations like statusCode, header type and one body element.
2. API end point fo Auckland city is captured and validations like statusCode, header type and one body element.
3. Auckland weather endpoint with the mandatory timezone parameter and asserted the responses.
