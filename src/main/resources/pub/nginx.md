### Nginx setup on remote server

```
cd /etc/nginx/sites-available
cat sensera.se
sudo cp sensera.se {file.se}
sudo nano {file.se}
```

### Create symlink
```
sudo ln -s /etc/nginx/sites-available/{file.se} /etc/nginx/sites-enabled/
```

### Create https certificate
```
sudo certbot --nginx -d {file.se}
Choose option (2) redirect
```

### Restart nginx load
```
sudo systemctl restart nginx
```