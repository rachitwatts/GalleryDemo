/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * aapt tool from the resource data it found.  It
 * should not be modified by hand.
 */

package sample.gallery;

public final class R {
    public static final class anim {
        public static final int fade_in=0x7f040000;
        public static final int fade_out=0x7f040001;
        public static final int slide_in=0x7f040002;
        public static final int slide_out=0x7f040003;
    }
    public static final class attr {
        /** <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int drawSelectorOnTop=0x7f010000;
        /** <p>Must be an integer value, such as "<code>100</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
         */
        public static final int numColumns=0x7f010001;
    }
    public static final class drawable {
        public static final int ic_launcher=0x7f020000;
    }
    public static final class id {
        public static final int gridview=0x7f080000;
        public static final int imageView1=0x7f080001;
        public static final int menu_item_caption=0x7f080004;
        public static final int pager=0x7f080002;
        public static final int txt_caption=0x7f080003;
    }
    public static final class layout {
        public static final int grid_view=0x7f030000;
        public static final int item_album_single_image=0x7f030001;
        public static final int pager_view=0x7f030002;
    }
    public static final class menu {
        public static final int pager_menu=0x7f070000;
    }
    public static final class string {
        public static final int app_name=0x7f050000;
        public static final int caption_default=0x7f050001;
    }
    public static final class style {
        /** 
        Base application theme, dependent on API level. This theme is replaced
        by AppBaseTheme from res/values-vXX/styles.xml on newer devices.
    

            Theme customizations available in newer API levels can go in
            res/values-vXX/styles.xml, while customizations related to
            backward-compatibility can go here.
        

        Base application theme for API 11+. This theme completely replaces
        AppBaseTheme from res/values/styles.xml on API 11+ devices.
    
 API 11 theme customizations can go here. 

        Base application theme for API 14+. This theme completely replaces
        AppBaseTheme from BOTH res/values/styles.xml and
        res/values-v11/styles.xml on API 14+ devices.
    
 API 14 theme customizations can go here. 
         */
        public static final int AppBaseTheme=0x7f060000;
        /**  Application theme. 
 All customizations that are NOT specific to a particular API-level can go here. 
         */
        public static final int AppTheme=0x7f060001;
    }
    public static final class styleable {
        /** Attributes that can be used with a StaggeredGridView.
           <p>Includes the following attributes:</p>
           <table>
           <colgroup align="left" />
           <colgroup align="left" />
           <tr><th>Attribute</th><th>Description</th></tr>
           <tr><td><code>{@link #StaggeredGridView_drawSelectorOnTop sample.gallery:drawSelectorOnTop}</code></td><td></td></tr>
           <tr><td><code>{@link #StaggeredGridView_numColumns sample.gallery:numColumns}</code></td><td></td></tr>
           </table>
           @see #StaggeredGridView_drawSelectorOnTop
           @see #StaggeredGridView_numColumns
         */
        public static final int[] StaggeredGridView = {
            0x7f010000, 0x7f010001
        };
        /**
          <p>This symbol is the offset where the {@link sample.gallery.R.attr#drawSelectorOnTop}
          attribute's value can be found in the {@link #StaggeredGridView} array.


          <p>Must be a boolean value, either "<code>true</code>" or "<code>false</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name sample.gallery:drawSelectorOnTop
        */
        public static final int StaggeredGridView_drawSelectorOnTop = 0;
        /**
          <p>This symbol is the offset where the {@link sample.gallery.R.attr#numColumns}
          attribute's value can be found in the {@link #StaggeredGridView} array.


          <p>Must be an integer value, such as "<code>100</code>".
<p>This may also be a reference to a resource (in the form
"<code>@[<i>package</i>:]<i>type</i>:<i>name</i></code>") or
theme attribute (in the form
"<code>?[<i>package</i>:][<i>type</i>:]<i>name</i></code>")
containing a value of this type.
          @attr name sample.gallery:numColumns
        */
        public static final int StaggeredGridView_numColumns = 1;
    };
}
