package com.example.advancedtouristsguide.CheckCredentials;

public class Validations {
    public boolean checkName(String name)
    {
        if(name.length()<6)return false;
        for(int i=0;i<name.length();i++)
        {
            char c=name.charAt((i));
            if(c < 65 || c> 122 || (c>91 && c<97))return false;
        }
        return true;
    }
    public boolean checkUserName(String username)
    {
        boolean isChar=false;
        boolean isNum=false;
        if(username.length()<6)return false;
        for(int i=0;i<username.length();i++)
        {
            char c = username.charAt(i);
            if (!isNum && c >47 && c<58)
                isNum=true;
            if(!isChar && (c>64 && c<92) || (c>96 && c<123))
                isChar=true;
        }
        return isChar && isNum;
    }
    public boolean checkPassword(String password)
    {
        if (password.length()<6)
            return false;
        boolean isChar=false;
        boolean isNum=false;
        boolean isUpper=false;
        boolean isLower=false;
        for(int i=0;i<password.length();i++)
        {
            char c = password.charAt(i);
            if (!isNum && c >47 && c<58)
                isNum=true;
            if(!isChar && (c>64 && c<92) || (c>96 && c<123))
                isChar=true;
            if(!isUpper && c>64 && c<92)
                isUpper=true;
            if(!isLower && c>64 && c<92)
                isLower=true;
        }
        return isChar && isNum && isUpper && isLower;
    }
    public boolean confirmPassword(String cpass,String password)
    {
        if(cpass.length()<6)return false;
        return cpass.equals(password);
    }
    public boolean checkEmail(String email)
    {
        if(email.length()<6)return false;
        if(!email.contains("@"))return false;
        boolean isNum=false;
        for(int i=0;i<email.length();i++)
        {
            char c=email.charAt(i);
            if(c>=48 && c<58)
                isNum=true;
        }
        return isNum;
    }
}
