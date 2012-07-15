package httpextractor.routes;


public class RouteFactory {

	public static Router loadRoutes(String routesClassName) {
		try {
			Class routesClass = Class.forName(routesClassName);
			Routes routes = (Routes) routesClass.newInstance();
			return new HttpRequestRouter(routes);
		} 
		catch (Exception e) {
			throw new RoutesConfigurationException(
					String.format("Configuration error finding routes definition class named %s", routesClassName), e);
		}
	}
}
