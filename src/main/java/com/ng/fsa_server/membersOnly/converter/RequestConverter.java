package com.ng.fsa_server.membersOnly.converter;

import com.ng.fsa_server.membersOnly.dto.RequestDTO;
import com.ng.fsa_server.membersOnly.model.Request;
import com.ng.fsa_server.membersOnly.model.User;
import com.ng.fsa_server.membersOnly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RequestConverter {

    @Autowired
    UserService userService;

    public RequestDTO toRequestDTO(Request request){
        User requestor = userService.findUserById(request.getUserId());
        return new RequestDTO(request.getCustomId(), request.getGroupId(), request.getUserId(), requestor.getFullName());
    }

    public List<RequestDTO> toRequestDTOList(List<Request> requestList){
        List<RequestDTO> requestDTOList = new ArrayList<>();

        for (Request request:requestList){
            requestDTOList.add(toRequestDTO(request));
        }

        return requestDTOList;
    }
}
