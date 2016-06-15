import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ola.google.ExcelParser;
import com.ola.google.LogParser;
import com.ola.google.RestService;

public class MainParserXLS {
		
	public static void main(String[] args) throws IOException {
		
		List<String> placeIds = LogParser.getPlaceIds();
		Map<String, String> placeformattedAddress = RestService.getFormattedAddressPlace(placeIds);
		Map<String, String> geoCodeformattedAddress = RestService.getFormattedAddressGeocode(placeIds);
		ExcelParser.writeXLSXFile(placeIds, placeformattedAddress, geoCodeformattedAddress);

	}
	
}