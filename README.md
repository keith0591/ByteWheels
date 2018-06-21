# ByteWheels
A Car service app
Take a pull and do the following
Make sure the JDK version is Java 8 or higher
Do the following-
-->Run the scripts specified in the ByteWheels master data folder.The master data folder contains two csv files while contain the master data
Before running the script make sure the csv path is correct
This script will create the tables and initilize them with master data.
-->mvn clean compile install -Dskip.test=true -Dpropfile="{specify the application.properties file path here}"
A copy of application is included in the main folder or you can also take it from the resources folder
The database connections and port no can be specified in the application.properties
After this the jar will be generated in the target folder
Go to the target folder and open a terminal here
--java -Dpropfile="{specify the application.properties file path here}" -jar {specify the jar to run here}
The application will start at the specified port

Now to Verify
Service 1 Get available cars
host:port/api/?fromDate=25-06-2018 13:22:00&toDate=30-07-2018 13:22:00
This sevices gives list of available cars within the specified dates.

Service 2 POST Book a car
host:port/api/book
{
	"fromDate":"25-06-2018 13:22:00",
	"toDate": "29-06-2018 13:22:00",
	"carId":4,
	"email":"kthsing.ms@gmail.com"
}

REsponse will be something like this
{
    "bookingId": 5,
    "carName": "Volkswagen Jetta",
    "emailId": "kthsing.ms@gmail.com",
    "totalCharge": 120
}
