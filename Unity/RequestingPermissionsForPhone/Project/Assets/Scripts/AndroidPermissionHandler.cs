using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using UnityEngine;
using UnityEngine.Android;

public class AndroidPermissionHandler : MonoBehaviour
{
    bool isItPermissionTime = false;
    string nextPermission;
    Stack<string> permissions = new Stack<string>();

    void Start()
    {
        OpenAllPermissions();
    }

    public void OpenAllPermissions()
    {
        isItPermissionTime = true;
        CreatePermissionList();

    }
    void CreatePermissionList()
    {
        permissions = new Stack<string>();

        permissions.Push(Permission.Camera);
        permissions.Push(Permission.Microphone);
        permissions.Push(Permission.FineLocation);
        permissions.Push(Permission.CoarseLocation);

        // Start: API 33+ thay thế: READ_EXTERNAL_STORAGE
        permissions.Push("android.permission.READ_MEDIA_IMAGES");
        permissions.Push("android.permission.READ_MEDIA_VIDEO");
        permissions.Push("android.permission.READ_MEDIA_AUDIO");
        // End

        // Start: < API 33
        permissions.Push(Permission.ExternalStorageRead);
        // End

        // Start: <= API 29 and phải có <application android:requestLegacyExternalStorage="true">
        permissions.Push(Permission.ExternalStorageWrite);
        // End

        permissions.Push("android.permission.POST_NOTIFICATIONS");

        AskForPermissions();
    }

    void AskForPermissions()
    {
        if (permissions == null || permissions.Count <= 0)
        {
            isItPermissionTime = false;
            return;
        }
        nextPermission = permissions.Pop();

        if (nextPermission == null)
        {
            isItPermissionTime = false;
            return;
        }
        if (Permission.HasUserAuthorizedPermission(nextPermission) == false)
        {
            Permission.RequestUserPermission(nextPermission);
        }
        else
        {
            if (isItPermissionTime == true)
                AskForPermissions();
        }
        Debug.Log("Unity>> permission " + nextPermission + "  status ;" + Permission.HasUserAuthorizedPermission(nextPermission));
    }

    private void OnApplicationFocus(bool focus)
    {
        Debug.Log("Unity>> focus ....  " + focus + "   isPermissionTime : " + isItPermissionTime);
        if (focus == true && isItPermissionTime == true)
        {
            AskForPermissions();
        }
    }
}
