this code is developed to restrict specific http request like in this i have restricted delete, put and option request which can be vulnerable anyone can change data using those request,
so on this i have created one annotation as interceptor so when any request coming to controller first go to interceptor and will check request if request allowed it will pass request to controller,
and if its not allowed it will throw exception .
