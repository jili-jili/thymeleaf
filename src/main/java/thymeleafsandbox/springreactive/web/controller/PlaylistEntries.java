/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package thymeleafsandbox.springreactive.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import thymeleafsandbox.springreactive.business.repository.PlaylistEntryRepository;


@Controller
public class PlaylistEntries {


    @Autowired
    private PlaylistEntryRepository playlistEntryRepository;



    public PlaylistEntries() {
        super();
    }



    @RequestMapping("/playlistentries.thymeleaf")
    public String playlistEntryListThymeleaf(final Model model) {
        model.addAttribute("entries", this.playlistEntryRepository.findAllPlaylistEntries());
        return "thymeleaf/playlistentries";
    }


    @RequestMapping("/playlistentries.freemarker")
    public String playlistEntryListFreeMarker(final Model model) {
        model.addAttribute("entries", this.playlistEntryRepository.findAllPlaylistEntries());
        return "freemarker/playlistentries";
    }


}
