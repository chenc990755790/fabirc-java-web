package com.ideal.blockchain.controller.block;

import com.ideal.blockchain.dao.postgres.ChannelRepository;
import com.ideal.blockchain.dto.response.ResultInfo;
import com.ideal.blockchain.enums.ResponseCodeEnum;
import com.ideal.blockchain.req.ChannelNameReq;
import com.ideal.blockchain.service.block.ChannelService;
import com.ideal.blockchain.service.block.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: LeonMa
 * @date: 2019/01/10 12:03
 */
@Slf4j
@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    private UserService userService;

    @Autowired
    private ChannelService channelService;

    @Autowired
    private ChannelRepository channelRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo createChannel(@RequestBody ChannelNameReq channelDto) {
        try {
            userService.loadUserFromPersistence(channelDto.getUserName(), channelDto.getPassWord(), channelDto.getPeerWithOrg());
            String response = channelService.constructChannel(channelDto.getChannelName(), channelDto.getPeerWithOrg());
            if (response == "Channel created successfully") {
                return new ResultInfo(ResponseCodeEnum.SUCCESS, "channel created successfully");
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        }
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo joinChannel(@RequestBody ChannelNameReq channelDto) {
        try {
            userService.loadUserFromPersistence(channelDto.getUserName(), channelDto.getPassWord(), channelDto.getPeerWithOrg());
            String response = channelService.joinChannel(channelDto.getChannelName(), channelDto.getPeerWithOrg());
            if (response == "Channel joined successfully") {
                return new ResultInfo(ResponseCodeEnum.SUCCESS, "channel join successfully");
            } else {
                return new ResultInfo(ResponseCodeEnum.FAILURE, "Something went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ResultInfo(ResponseCodeEnum.FAILURE, e.getMessage());
        }
    }

    @RequestMapping(value = "/queryChannelsData", method = RequestMethod.GET)
    @ResponseBody
    public ResultInfo queryChannelsData() {
        return new ResultInfo(ResponseCodeEnum.SUCCESS, channelRepository.findAll());
    }
}
