package org.desafio_api.supports;

import org.desafio_api.utils.ObjectsUtils;

public class EndPoints {

    protected static final String BASE_URI = ObjectsUtils.getPropertiesData("endpoints", "BASE_URI");
    protected static final String CEP_PUCRS = ObjectsUtils.getPropertiesData("endpoints", "CEP_PUCRS");
    protected static final String JSON = ObjectsUtils.getPropertiesData("endpoints", "JSON");
    protected static final String EXTRA = ObjectsUtils.getPropertiesData("endpoints", "EXTRA");

}
