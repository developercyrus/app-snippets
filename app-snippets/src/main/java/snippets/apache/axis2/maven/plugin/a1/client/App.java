package snippets.apache.axis2.maven.plugin.a1.client;

import java.rmi.RemoteException;

import snippets.apache.axis2.maven.plugin.a1.stub.GlobalWeatherStub;

public class App {
    public static void main(String[] args) throws RemoteException {
        GlobalWeatherStub stub = new GlobalWeatherStub();
        GlobalWeatherStub.GetWeather weatherRequest = new GlobalWeatherStub.GetWeather();
        weatherRequest.setCountryName("Korea");
        weatherRequest.setCityName("Seoul");
        GlobalWeatherStub.GetWeatherResponse weatherResponse =
        stub.getWeather(weatherRequest);
        System.out.println("================= Country / City / Weather =================");
        System.out.println(weatherResponse.getGetWeatherResult());
    }
}


