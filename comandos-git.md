# Comandos de Git

## Traerte los cambios

```bash 
# en master
git pull 

# mergearte los cambios del master de github
git pull origin master 
```

## Crear un branch

```bash
git checkout -b <nombre-branch>
```

## Cambiar de branch

```bash
git checkout <nombre-brach>
```

## Commitear cambios

```bash
# recordar: hacer los cambios en tu branch, no en master

# ver estado del branch
git status
# preparar el commit
git add <archivos con cambios>
# confirmar el commit
git commit -m "mensaje descriptivo y corto de los cambios del commit."
# subir los cambios a github
git push origin <tu-branch>
```

## Agregar tus cambios a master

```bash
# parado en tu branch
git pull origin master # esto te mergear el master de github
# si te genero un commit de merge
git push origin <tu-branch>

# te moves a master
git checkout master
# mergear parado en master
git merge <tu-branch>
# subir lo mergeado a github
git push origin master
```
