## TriangularImageFilterList

### Android module to create a list of triangle shaped images which on clicked will be selected and a opaque filter will be applied.

### Usage

#### Creating a TriangularImageFilterList in Activity

```
    TriangularImageFilterList trianguleImageFilterList = new TriangularImageFilterList(this);
```

#### Adding an image in trianguleImageFilterList 1st parameter is the bitmap object and second the onselectionchangelistener

```
    trianguleImageFilterList.addImage(bitmap,new OnSelectionChangeListener(){
        public void onSelect() {
            //Your code
        }
        public void onUnSelect() {
            //Your code
        }
    })
```
#### Showing the trianguleImageFilterList
```
    trianguleImageFilterList.show();
```

#### Demo

<img src="https://github.com/Anwesh43/TriangularImageFilterList/blob/master/demo/triangularimagefilterlist.gif" width="300px" height="500px">
