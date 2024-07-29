package org.desafio_api.stubs;

import org.desafio_api.dto.ViaCepDTO;

public class ViaCepStub {

    public static ViaCepDTO ViaCepStub() {
        ViaCepDTO cepDto = new ViaCepDTO();
        cepDto.setCep("92440-094");
        cepDto.setLogradouro("Quadra N Um");
        cepDto.setComplemento("");
        cepDto.setUnidade("");
        cepDto.setBairro("Guajuviras");
        cepDto.setLocalidade("Canoas");
        cepDto.setUf("RS");
        cepDto.setIbge("4304606");
        cepDto.setGia("");
        cepDto.setDdd("51");
        cepDto.setSiafi("8589");
        return cepDto;
    }

}