package com.gafahtec.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {

	public Map upload(File file) throws IOException;
}
