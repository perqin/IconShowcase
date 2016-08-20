/*
 * Copyright (c) 2016.  Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Big thanks to the project contributors. Check them in the repository.
 *
 */

package jahirfiquitiva.iconshowcase.views;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;

import com.afollestad.materialdialogs.internal.MDTintHelper;

import jahirfiquitiva.iconshowcase.utilities.ThemeUtils;
import jahirfiquitiva.iconshowcase.utilities.color.ColorUtils;

public class RequestsCheckBox extends AppCompatCheckBox {

    public RequestsCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setProperTint(context);
    }

    public RequestsCheckBox(Context context) {
        super(context);
        setProperTint(context);
    }

    public RequestsCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        setProperTint(context);
    }

    private void setProperTint(Context context) {
        MDTintHelper.setTint(this, ColorUtils.getCheckBoxColor(context,
                ColorUtils.getMaterialTertiaryColor(ThemeUtils.darkTheme)));
    }

}