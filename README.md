# webhook
Evaluation repository for yaya wallet

1. run '**mvn clean install**' command to build the project. This requires maven to be installed on the machine. 
2. run **docker build** and **tag** on {BASE_FOLDER}
3. make sure to have mysql database running locally with '**root**' user-name and '**password**' as password. Then create a database '**transactions_db**'
4. execute docker run command, the application should be starting.   
5. To send transaction notification, check the Postman collection(**webhook.postman_collection.json**) found in this directory