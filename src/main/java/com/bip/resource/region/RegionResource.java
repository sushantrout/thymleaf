package com.bip.resource.region;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class RegionResource {
	@GetMapping(value = "/regions")
	public List<String> getRegions(@RequestParam String country) {
		System.out.println(country);

		List<String> regions = new ArrayList<>();
		regions.add("--Please Select--");
		regions.add("ODISHA");
		regions.add("BIHAR");
		regions.add("UP");
		regions.add("AP");

		return regions;
	}
	@GetMapping(value = "/city")
	public List<String> getCitys(@RequestParam String country) {
		System.out.println(country);

		List<String> regions = new ArrayList<>();
		regions.add("--Please Select--");
		regions.add("CITY1");
		regions.add("CITY2");
		regions.add("CITY3");
		regions.add("CITY4");

		return regions;
	}
}
