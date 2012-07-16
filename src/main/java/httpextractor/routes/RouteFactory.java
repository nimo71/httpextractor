package httpextractor.routes;


public class RouteFactory {

	@SuppressWarnings("unchecked")
	public static Router loadRoutes(String routesClassName) {
		try {
			Class<Routes> routesClass = (Class<Routes>) Class.forName(routesClassName);
			Routes routes = routesClass.newInstance();
			return new HttpRequestRouter(routes);
		} 
		catch (Exception e) {
			throw new RoutesConfigurationException(
					String.format("Configuration error finding routes definition class named %s", routesClassName), e);
		}
	}
}
