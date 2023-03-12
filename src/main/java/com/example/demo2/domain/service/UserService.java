package com.example.demo2.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo2.domain.model.User;
import com.example.demo2.domain.repository.UserMapper;

@Service
public class UserService {

    @Value("${demo2.user_num_per_page}")
    private int numPerPage;

    @Autowired
    private UserMapper mapper;

    public List<User> getUsers(){
        return mapper.findAll();
    }

    public User getUserById(int id){
        return mapper.findOneById(id);
    }

    // ページ総数を算出
    public long getPageTotal(){
        long userTotalNum = mapper.numOfRows();
        long left = userTotalNum % numPerPage;
        return left > 0 ?  (userTotalNum / numPerPage) + 1: (userTotalNum / numPerPage);
    }

    // ページ番号を指定してそのページのユーザーリストを返却(1ページが最初)
    public List<User> getUsersByPageNo(long pageNo){
        long offset = (pageNo - 1) * numPerPage;
        return mapper.findUsersByPageNo(numPerPage, offset);
    }

    // パラメータを１つづつ渡して生成
    public int createUser(String name, String mailAddress){
        return mapper.insertOne(name, mailAddress);
    }

    // userオブジェクトを渡して生成.オーバーロード
    public int createUser(User user){
        return this.createUser(user.getName(), user.getMailAddress());
    }


    public int updateUser(int userId, String userName, String mailAddress){
        return mapper.updateOne(userId, userName, mailAddress);
    }

    public int deleteUser(int id){
        return mapper.deleteOne(id);
    }

}
